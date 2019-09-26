package test;

import java.io.InputStream;
import java.io.Serializable;


public class XpBean implements Serializable {
    private String cname,caddr,cdis,uname,pword,fname,lname,addr,mid,branch;;
    private int pckg,gcy;
    private long phno;
    private InputStream is;
    public XpBean(){}

  

    
    public String getCname() {
        return cname;
    }

   
    public void setCname(String cname) {
        this.cname = cname;
    }

    
    public String getCaddr() {
        return caddr;
    }

  
    public void setCaddr(String caddr) {
        this.caddr = caddr;
    }

 
    public String getCdis() {
        return cdis;
    }

  
    public void setCdis(String cdis) {
        this.cdis = cdis;
    }

  
    public String getUname() {
        return uname;
    }

   
    public void setUname(String uname) {
        this.uname = uname;
    }

    
    public String getPword() {
        return pword;
    }

   
    public void setPword(String pword) {
        this.pword = pword;
    }

    public String getFname() {
        return fname;
    }

  
    public void setFname(String fname) {
        this.fname = fname;
    }

  
    public String getLname() {
        return lname;
    }

  
    public void setLname(String lname) {
        this.lname = lname;
    }

 
    public String getAddr() {
        return addr;
    }

   
    public void setAddr(String addr) {
        this.addr = addr;
    }

   
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    
    public String getBranch() {
        return branch;
    }

 
    public void setBranch(String branch) {
        this.branch = branch;
    }

   
    public int getPckg() {
        return pckg;
    }

   
    public void setPckg(int pckg) {
        this.pckg = pckg;
    }

   
    public int getGcy() {
        return gcy;
    }

   
    public void setGcy(int gcy) {
        this.gcy = gcy;
    }


    public long getPhno() {
        return phno;
    }

    
    public void setPhno(long phno) {
        this.phno = phno;
    }
       public InputStream getIs() {
        return is;
    }

    
    public void setIs(InputStream is) {
        this.is = is;
    }

   

    
    
}
