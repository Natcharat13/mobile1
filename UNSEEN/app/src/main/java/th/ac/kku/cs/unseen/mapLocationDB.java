package th.ac.kku.cs.unseen;

public class mapLocationDB {
    private String id_location;
    private String name_loca;
    private String img_loca;
    private String data_loca;

    public static final String BASE_URL_UNSEEN = "http://172.20.10.2/unseen/";
    public String getId_location() {
        return id_location;
    }

    public void setId_location(String id_location) {
        this.id_location = id_location;
    }
    public String getName_loca() {
        return name_loca;
    }
    public void setName_loca(String name_loca) {
        this.name_loca = name_loca;
    }
    public String getImg_loca() {
        return img_loca;
    }
    public void setImg_loca(String img_loca) {
        this.img_loca = img_loca;
    }
    public String getData_loca() {
        return data_loca;
    }
    public void setData_loca(String data_loca) {
        this.data_loca = data_loca;
    }
}

