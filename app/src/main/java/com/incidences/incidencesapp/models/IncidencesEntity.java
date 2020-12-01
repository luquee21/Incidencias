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

    /**
     * error 0 = ok
     * error 1 = name empty
     * error 2 = name can only contain letters and/or numbers
     */

    public int setName(String name) {
        int error = 0;
        if (name != null && name.length() > 0) {
            Pattern pat = Pattern.compile("[A-Za-zÑñ0-9\\s]+");
            Matcher mat = pat.matcher(name.trim());
            if (mat.matches()) {
                this.name = name;
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

    /**
     * error 0 = ok
     * error 1 = site empty
     * error 2 = site can only contain letters and/or numbers
     */
    public int setSite(String site) {
        int error = 0;
        if (site != null && site.length() > 0) {
            Pattern pat = Pattern.compile("[A-Za-zÑñ0-9\\s]+");
            Matcher mat = pat.matcher(site.trim());
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


    /**
     * error 0 = ok
     * error 1 = phone empty
     * error 2 = phone can only contain numbers
     * error 3 = phone can only contain 9 digits
     */
    public int setPhone(String phone) {
        int error = 0;
        if (phone != null && phone.length() > 0) {
            Pattern pat = Pattern.compile("\\d{9}");
            Matcher mat = pat.matcher(phone);
            if (mat.matches()) {
                this.phone = phone;
            } else if (phone.length() != 9) {
                error = 3;
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

    /**
     * error 0 = ok
     * error 1 = description empty
     */
    public int setDescription(String description) {
        int error = 0;
        if (description != null && description.length() > 0) {
            this.description = description;
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
