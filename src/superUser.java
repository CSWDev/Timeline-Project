public class superUser
{

    private String password;
    private String firstname;
    private String lastname;
    private boolean admim;

    public superUser()
    {

    }

    public superUser(String username, String password)
    {
        this.username = username;
        this.password = password;
    }


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    private String username;

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public boolean getAdmin()
    {
        return admim;
    }

    public void setAdmim(boolean admim)
    {
        this.admim = admim;
    }

}