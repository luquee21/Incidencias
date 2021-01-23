package com.incidences.incidencesapp.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class IncidencesEntity extends RealmObject {
    @PrimaryKey
    private String id;
    private String name;
    private String site;
    private String phone;
    private String description;
    private String date;
    private String image;

    public IncidencesEntity() {
    }

    public IncidencesEntity(String name, String date, String image) {
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    /**
     * error 0 = ok
     * error 1 = name empty
     * error 2 = name can only contain letters and/or numbers
     */

    public String setName(String name) {
        String error = "";
        if (name != null && name.length() > 0) {
            Pattern pat = Pattern.compile("[A-Za-zÑñ0-9\\s]+");
            Matcher mat = pat.matcher(name.trim());
            if (mat.matches()) {
                this.name = name;
            } else {
                error = "name_bad_format";
            }
        } else {
            error = "name_empty";
        }
        return error;
    }

    public String getSite() {
        return site;
    }

    /**
     * error 0 = ok
     * error 1 = site empty
     * error 2 = site can only contain letters and/or numbers
     */
    public String setSite(String site) {
        String error = "";
        if (site != null && site.length() > 0) {
            Pattern pat = Pattern.compile("[A-Za-zÑñ0-9\\s]+");
            Matcher mat = pat.matcher(site.trim());
            if (mat.matches()) {
                this.site = site;
            } else {
                error = "site_bad_format";
            }
        } else {
            error = "site_empty";
        }
        return error;
    }

    public String getPhone() {
        return phone;
    }


    /**
     * error 0 = ok
     * error 1 = phone empty
     * error 2 = phone can only contain numbers
     * error 3 = phone can only contain 9 digits
     */
    public String setPhone(String phone) {
        String error = "";
        if (phone != null && phone.length() > 0) {
            Pattern pat = Pattern.compile("\\d{9}");
            Matcher mat = pat.matcher(phone);
            if (mat.matches()) {
                this.phone = phone;
            } else if (phone.length() != 9) {
                error = "phone_only_9_digits";
            } else {
                error = "phone_only_numbers";
            }
        } else {
            error = "phone_empty";
        }
        return error;
    }

    public String getDescription() {
        return description;
    }

    /**
     * error 0 = ok
     * error 1 = description empty
     */
    public String setDescription(String description) {
        String error = "";
        if (description != null && description.length() > 0) {
            this.description = description;
        } else {
            error = "description_empty";
        }
        return error;
    }

    public String getDate() {
        return date;
    }

    public String setDate(String date) {
        String error = "";
        if (!date.isEmpty()) {
            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
            dateformat.setLenient(false);
            try {
                dateformat.parse(date);
                this.date = date;
            } catch (ParseException e) {
                e.printStackTrace();
                error = "date_bad_format";
            }

        } else {
            error = "date_empty";
        }

        return error;
    }

    @Override
    public String toString() {
        return "IncidencesEntity{" +
                ", name='" + name + '\'' +
                ", site='" + site + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
