package mobcom.ilkom.unsri.unsriguidemap;

/**
 * Created by Hasby on 10/12/2015.
 */
public class Fakultas {
    private String ID;
    private String name;
    private String description;
    private String image;

    public Fakultas(String ID, String name, String description, String image){
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public String getImage(){
        return this.image;
    }
}
