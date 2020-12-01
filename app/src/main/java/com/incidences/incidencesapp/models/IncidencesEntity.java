package com.incidences.incidencesapp.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IncidencesEntity {

    private String name;
    private String site;
    private String phone;
    private String description;
    private String date;

    public String getName() {
        return name;
    }

    public int setName(String name) {
        int error = 0;
        if (name != null && name.length() > 0) {
            Pattern pat = Pattern.compile("[A-Za-zÑñ0-9]+");
            Matcher mat = pat.matcher(name);
            if (mat.matches()) {
                this.name = name.toUpperCase();
            } else {
                error = 2;
            }
        } else {
            error = 1;
        }
        return error;
    }

    public String getSite() {
        return site;
    }

    public int setSite(String site) {
        int error = 0;
        if (site != null && site.length() > 0) {
            Pattern pat = Pattern.compile("[A-Za-zÑñ0-9]+");
            Matcher mat = pat.matcher(site);
            if (mat.matches()) {
                this.site = site;
            } else {
                error = 2;
            }
        } else {
            error = 1;
        }
        return error;
    }

    public String getPhone() {
        return phone;
    }

    public int setPhone(String phone) {
        int error = 0;
        if (phone != null && phone.length() > 0) {
            Pattern pat = Pattern.compile("[0-9]+");
            Matcher mat = pat.matcher(phone);
            if (mat.matches()) {
                this.phone = phone;
            } else {
                error = 2;
            }
        } else {
            error = 1;
        }
        return error;
    }

    public String getDescription() {
        return description;
    }

    public int setDescription(String description) {
        int error = 0;
        if (description != null && description.length() > 0) {
            Pattern pat = Pattern.compile("[A-Za-zÑñ0-9]+");
            Matcher mat = pat.matcher(description);
            if (mat.matches()) {
                this.description = description.toUpperCase();
            } else {
                error = 2;
            }
        } else {
            error = 1;
        }
        return error;
    }

    public String getDate() {
        return date;
    }

    public int setDate(String date) {
        int result = 0;
        if (!date.isEmpty()) {
            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
            dateformat.setLenient(false);
            try {
                dateformat.parse(date);
                this.date = date;
            } catch (ParseException e) {
                e.printStackTrace();
                result = 2;
            }

        } else {
            result = 1;
        }

        return result;
    }
}
