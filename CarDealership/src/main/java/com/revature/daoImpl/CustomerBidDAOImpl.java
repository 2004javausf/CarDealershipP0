package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.CustomerBid;
import com.revature.dao.CustomerBidDAO;
import com.revature.util.ConnFactory;

public class CustomerBidDAOImpl implements CustomerBidDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn;

	@Override
	public void createCustomerBid(int car_id, int customer_id, double offer_made) {

		try {
			conn = cf.getConnection();
			String sql = "INSERT INTO customer_bid( car_id, customer_id, months, offer_made) VALUES (?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, car_id);

			ps.setLong(2, customer_id);
			ps.setLong(3, 1); // 1 month

			ps.setDouble(4, offer_made);

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void rejectCustomerBid(int bid_id) {
		conn = cf.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from customer_bid where bid_id =?");

			stmt.setInt(1, bid_id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void acceptCustomerBid(int bid_id) {

		CustomerOwnedCarsDAOImpl s = new CustomerOwnedCarsDAOImpl();
		DealerPaymentsDAOImpl d = new DealerPaymentsDAOImpl();

		CustomerBid bid = getBidById(bid_id);
		removeCarFromAllBids(bid.getCar_id());

		s.addCarToCustomer(bid.getCustomer_id(), bid.getCar_id(), bid.getOffer_made(), false);
		d.createPayment(bid.getCustomer_id(), bid.getCar_id(), bid.getOffer_made());
	}

	@Override
	public void removeCarFromAllBids(int car_id) {

		conn = cf.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from customer_bid where car_id =?");

			stmt.setInt(1, car_id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public CustomerBid getBidById(int bid_id) {

		CustomerBid bid = null;
		try {
			conn = cf.getConnection();
			String sql = "SELECT * FROM customer_bid where bid_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, bid_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bid = new CustomerBid();
				
				
				bid = new CustomerBid();
				bid.setCar_id(rs.getInt("car_id"));
				bid.setCustomer_id(rs.getInt("customer_id"));
				bid.setBid_id(rs.getInt("bid_id"));
				bid.setOffer_made(rs.getDouble("offer_made"));
				bid.setMonths(rs.getInt("months"));

			}
			return bid;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	public List<CustomerBid> getAllBids() {
		List<CustomerBid> bids = new ArrayList<CustomerBid>();
		try {
			conn = cf.getConnection();
			String sql = "SELECT * FROM customer_bid";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CustomerBid bid = new CustomerBid();
				
				
				bid = new CustomerBid();
				bid.setCar_id(rs.getInt("car_id"));
				bid.setCustomer_id(rs.getInt("customer_id"));
				bid.setBid_id(rs.getInt("bid_id"));
				bid.setOffer_made(rs.getDouble("offer_made"));
				bid.setMonths(rs.getInt("months"));
				
				bids.add(bid);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return bids;
	}

	@Override
	public void rejectBid(int bid) {

		conn = cf.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from customer_bid where bid_id =?");

			stmt.setInt(1, bid);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}