package rbc.one.app.workflow.bean;

import java.io.Serializable;


public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 451857561924533808L;
	private String promotorCode;
	private String promotorName;
	private String fundName;
	private String shareClass;
	private String juridiction;
	public Account createRegistredAdress(String streetAdress, String floor, String city){
		RegistredAddress registredAddress = new RegistredAddress(streetAdress, floor, city);
		setRegistredAdress(registredAddress);
		return this;
		
	}
	public Account createAccountInfo(String accountName, String accountNumber, String clientIdentifier){
		AccountInfo accountInfo = new AccountInfo( accountName,  accountNumber,  clientIdentifier);
		setAccountInfo(accountInfo);
		return this;
	}
    public String getPromotorCode() {
		return promotorCode;
	}
	public Account setPromotorCode(String promotorCode) {
		this.promotorCode = promotorCode;
		return this;
	}
	public String getPromotorName() {
		return promotorName;
	}
	public Account setPromotorName(String promotorName) {
		this.promotorName = promotorName;
		return this;
	}
	public String getFundName() {
		return fundName;
	}
	public Account setFundName(String fundName) {
		this.fundName = fundName;
		return this;
	}
	public String getShareClass() {
		return shareClass;
	}
	public Account setShareClass(String shareClass) {
		this.shareClass = shareClass;
		return this;
	}
	public String getJuridiction() {
		return juridiction;
	}
	public Account setJuridiction(String juridiction) {
		this.juridiction = juridiction;
		return this;
	}
	public RegistredAddress getRegistredAdress() {
		return registredAdress;
	}
	public Account setRegistredAdress(RegistredAddress registredAdress) {
		this.registredAdress = registredAdress;
		return this;
	}
	public AccountInfo getAccountInfo() {
		return accountInfo;
	}
	public Account setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
		return this;
	}
	private RegistredAddress registredAdress;
    private AccountInfo accountInfo;
    private class RegistredAddress implements Serializable{
    	/**
		 * 
		 */
		private static final long serialVersionUID = -8674263761281775890L;
		public RegistredAddress(String streetAdress, String floor, String city) {
			super();
			this.streetAdress = streetAdress;
			this.floor = floor;
			this.city = city;
		}
		public String getStreetAdress() {
			return streetAdress;
		}
		public RegistredAddress setStreetAdress(String streetAdress) {
			this.streetAdress = streetAdress;
			return this;
		}
		public String getFloor() {
			return floor;
		}
		public RegistredAddress setFloor(String floor) {
			this.floor = floor;
			return this;
		}
		public String getCity() {
			return city;
		}
		public RegistredAddress setCity(String city) {
			this.city = city;
			return this;
		}
		private String streetAdress;
    	private String floor;
    	private String city;
    }
    private class AccountInfo implements Serializable{
    	/**
		 * 
		 */
		private static final long serialVersionUID = 7078343106216653337L;
		public AccountInfo(String accountName, String accountNumber, String clientIdentifier) {
			super();
			this.accountName = accountName;
			this.accountNumber = accountNumber;
			this.clientIdentifier = clientIdentifier;
		}
		private String accountName;
        public String getAccountName() {
			return accountName;
		}
		public AccountInfo setAccountName(String accountName) {
			this.accountName = accountName;
			return this;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public AccountInfo setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
			return this;
		}
		public String getClientIdentifier() {
			return clientIdentifier;
		}
		public AccountInfo setClientIdentifier(String clientIdentifier) {
			this.clientIdentifier = clientIdentifier;
			return this;
		}
		private String accountNumber;
        private String clientIdentifier;
    }
}
