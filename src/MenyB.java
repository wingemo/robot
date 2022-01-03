package com.company;

/**
 * The Class MenyB.
 */
public class MenyB {
    
    /** The account. */
    private String password, pid, account;

    /**
     * Instantiates a new meny B.
     *
     * @param password the password
     * @param account the account
     * @param pid the pid
     */
    public MenyB(String password, String account, String pid) {
        this.password = password;
        this.account = account;
        this.pid = pid;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the account.
     *
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the account.
     *
     * @param account the new account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Gets the pid.
     *
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * Sets the pid.
     *
     * @param pid the new pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "MenyB{" +
                "password='" + password + '\'' +
                ", account='" + account + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }

}
