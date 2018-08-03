public class Figure
{
    private String firstname;
    private String lastname;
    private int DOB;
    private int DOD;
    private String details;

    public Figure(){}

    public Figure(String Firstname, String Lastname, int dob, int dod, String Details){
        this.firstname = Firstname;
        this.lastname = Lastname;
        this.DOB = dob;
        this.DOD = dod;
        this.details = Details;
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



    public int getDOB()
    {
        return DOB;
    }

    public void setDOB(int DOB)
    {
        this.DOB = DOB;
    }



    public int getDOD()
    {
        return DOD;
    }

    public void setDOD(int DOD)
    {
        this.DOD = DOD;
    }



    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }





}
