package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.DealerPayments;
import com.revature.dao.DealerPaymentsDAO;
import com.revature.util.ConnFactory;

public class DealerPaymentsDAOImpl implements DealerPaymentsDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn;

	@Override
	public void createPayment(int customer_id, int car_id, double amount) {

		try {
			conn = cf.getConnection();
			String sql = "INSERT INTO dealer_payments( customer_id, car_id, amount, payment_date) VALUES (?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);


			ps.setLong(1, customer_id);
			ps.setLong(2, car_id);

			ps.setDouble(3, amount);

			ps.setDate(4, new Date(System.currentTimeMillis()));

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public double getMonthlyPayments(int year, int month) {
		
		List<DealerPayments> payments = new ArrayList<DealerPayments>();
		try {
			conn = cf.getConnection();
			String sql = "SELECT * FROM dealer_payments where payment_date BETWEEN ? and ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			YearMonth yearMonth = YearMonth.of( year, month );  
			LocalDate firstOfMonth = yearMonth.atDay( 1 );
			LocalDate last = yearMonth.atEndOfMonth();
			
			
			
			ps.setDate(1, new java.sql.Date(firstOfMonth.now().atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()));
			ps.setDate(2, new java.sql.Date(last.now().atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()));
			
			System.out.println(ps.toString());
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				DealerPayments payment = new DealerPayments();

				payment.setCar_id(rs.getInt("car_id"));
				payment.setAmount(rs.getDouble("amount"));
				payment.setPayment_id(rs.getInt("payment_id"));
				payment.setCustomer_id(rs.getInt("customer_id"));

				payments.add(payment);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		double amount = 0;
		
		for(DealerPayments p : payments) {
			amount+=p.getAmount();
		}
		
		return amount;
	}

	@Override
	public List<DealerPayments> getAllPayments() {

		List<DealerPayments> payments = new ArrayList<DealerPayments>();
		try {
			conn = cf.getConnection();
			String sql = "SELECT * FROM dealer_payments";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				DealerPayments payment = new DealerPayments();

				payment.setCar_id(rs.getInt("car_id"));
				payment.setAmount(rs.getDouble("amount"));
				payment.setPayment_id(rs.getInt("payment_id"));
				payment.setCustomer_id(rs.getInt("customer_id"));
				payment.setPayment_date(rs.getDate("payment_date"));


				payments.add(payment);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return payments;
	}
}