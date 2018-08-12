package cmd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory {

    private final String name;
    private final Date dateOfCreation;
    private List<Directory> subDirectoryList;

    /**
     * Directory Constructor
     *
     * @param name           of folder
     * @param dateOfCreation is time when folder is created
     */
    public Directory(String name, Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
        this.name = name;
        this.subDirectoryList = new ArrayList<>();
    }

    public List<Directory> getSubDirectoryList() {
        return subDirectoryList;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }
}