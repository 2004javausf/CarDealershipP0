	package com.revature.beans;

	public class Car{
	    //fields
		private String owner;
	    private int VIN;
	    private String model;
	    private String make;
	    private int year;
	    private int mileage;
	    private double price;
	    private double rate;
	    private double monthlyPayment;
	    
	//Constructors
	    public Car() {};   // no args constructor
	    public Car(String owner, int vIN, String model, String make, int year, int mileage, double price, double rate,
				double monthlyPayment) {
			super();
			this.owner = owner;
			VIN = vIN;
			this.model = model;
			this.make = make;
			this.year = year;
			this.mileage = mileage;
			this.price = price;
			this.rate = rate;
			this.monthlyPayment = monthlyPayment;
		}
	    

	    //Getters and Setters
	    public String getOwner() {
			return owner;
		}
		public void setOwner(String owner) {
			this.owner = owner;
		}
		public int getVIN() {
			return VIN;
		}
		public void setVIN(int vIN) {
			VIN = vIN;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public String getMake() {
			return make;
		}
		public void setMake(String make) {
			this.make = make;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public int getMileage() {
			return mileage;
		}
		public void setMileage(int mileage) {
			this.mileage = mileage;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getRate() {
			return rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}
		public double getMonthlyPayment() {
			return monthlyPayment;
		}
		public void setMonthlyPayment(double monthlyPayment) {
			this.monthlyPayment = monthlyPayment;
		}
	    

	    @Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Car other = (Car) obj;
			if (VIN != other.VIN)
				return false;
			if (make == null) {
				if (other.make != null)
					return false;
			} else if (!make.equals(other.make))
				return false;
			if (mileage != other.mileage)
				return false;
			if (model == null) {
				if (other.model != null)
					return false;
			} else if (!model.equals(other.model))
				return false;
			if (Double.doubleToLongBits(monthlyPayment) != Double.doubleToLongBits(other.monthlyPayment))
				return false;
			if (owner == null) {
				if (other.owner != null)
					return false;
			} else if (!owner.equals(other.owner))
				return false;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
				return false;
			if (year != other.year)
				return false;
			return true;
		}

	    @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + VIN;
			result = prime * result + ((make == null) ? 0 : make.hashCode());
			result = prime * result + mileage;
			result = prime * result + ((model == null) ? 0 : model.hashCode());
			long temp;
			temp = Double.doubleToLongBits(monthlyPayment);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((owner == null) ? 0 : owner.hashCode());
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(rate);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + year;
			return result;
		}
	    @Override
		public String toString() {
			return "Car [owner=" + owner + ", VIN=" + VIN + ", model=" + model + ", make=" + make + ", year=" + year
					+ ", mileage=" + mileage + ", price=" + price + ", rate=" + rate + ", monthlyPayment="
					+ monthlyPayment + "]";
		}
   

}
