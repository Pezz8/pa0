package pa0;

public class Usage {

    private String user;
    private int count;

    public Usage(String user, int count){
        setUser(user);
        setCount(count);
    }

    public void setUser(String user){
        this.user = user;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void increment(){
        this.count++;
    }

    public String getUser(){
        return this.user;
    }

    public int getCount(){
        return this.count;
    }
}
