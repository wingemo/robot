package com.company;

public class MenyB {
    private String password, pid, account;

    public MenyB(String password, String account, String pid) {
        this.password = password;
        this.account = account;
        this.pid = pid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "MenyB{" +
                "password='" + password + '\'' +
                ", account='" + account + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }

}
