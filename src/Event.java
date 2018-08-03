public class Event {
    private String title;
    private String Details;
    private int startDate;
    private int endDate;
    private String Links;
    private String img;
    private String image;



    public Event() { }



    public Event(String Title, int startDate, int endDate, String Details, String Link, String imgpath) {
        this.title = Title;
        this.Details = Details;
        this.startDate = startDate;
        this.endDate = endDate;
        this.Links = Link;
        this.img = imgpath;

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }



    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }



    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }



    public String getLinks() {
        return Links;
    }

    public void setLinks(String links) {
        Links = links;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
