package com.incidences.incidencesapp;

import com.incidences.incidencesapp.models.IncidencesEntity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncidencesTest {
    private IncidencesEntity incidences;

    @Before
    public void setUp() {
        this.incidences = new IncidencesEntity();
    }

    @Test
    public void incidencesId() {
        this.incidences.setId("213213");
        assertEquals("213213", this.incidences.getId());
        this.incidences.setId("213884");
        assertEquals("213884", this.incidences.getId());
    }

    @Test
    public void incidencesName() {
        assertEquals("", this.incidences.setName("incidences in a roof"));
        assertEquals("name_bad_format", this.incidences.setName("this is an, incidence with %·!"));
        assertEquals("name_bad_format", this.incidences.setName("oh no incidence *$"));
        assertEquals("incidences in a roof", this.incidences.getName());
    }

    @Test
    public void incidencesDescription() {
        assertEquals("", this.incidences.setDescription("incidence in my street, this is a test only"));
        assertEquals("description_empty", this.incidences.setDescription(""));
        assertEquals("incidence in my street, this is a test only", this.incidences.getDescription());
    }

    @Test
    public void incidencesPhone() {
        assertEquals("", this.incidences.setPhone("786251632"));
        assertEquals("phone_only_9_digits", this.incidences.setPhone("11111111111111111"));
        assertEquals("phone_only_numbers", this.incidences.setPhone("123hasjdy"));
        assertEquals("786251632", this.incidences.getPhone());
    }

    @Test
    public void incidencesSite() {
        assertEquals("site_empty", this.incidences.setSite(""));
        assertEquals(null, this.incidences.getSite());
        assertEquals("site_bad_format", this.incidences.setSite("&%&%& here is"));
        assertEquals("", this.incidences.setSite("is here"));
        assertEquals("is here", this.incidences.getSite());
    }

    @Test
    public void incidencesDate() {
        assertEquals("", this.incidences.setDate("21/11/1998"));
        assertEquals("date_bad_format", this.incidences.setDate("50/02/1004"));
        assertEquals("date_empty", this.incidences.setDate(""));
        assertEquals("21/11/1998", this.incidences.getDate());
    }

    @Test
    public void incidencesSeverity() {
        assertEquals("severity_empty", this.incidences.setSeverity(""));
        assertEquals("", this.incidences.setSeverity("moderate"));
        assertEquals("moderate", this.incidences.getSeverity());
    }

    @Test
    public void incidencesResolved() {
        this.incidences.setResolved(true);
        assertEquals(true, this.incidences.isResolved());
        this.incidences.setResolved(false);
        assertEquals(false, this.incidences.isResolved());
    }

    @Test
    public void memeImage() {
        this.incidences.setImage("R-yes8f9ds7f2safdsfknjv3");
        assertEquals("R-yes8f9ds7f2safdsfknjv3", this.incidences.getImage());
        this.incidences.setImage("rogihy98ti}#~@]trfsd,godfsg8sdvjsdf");
        assertEquals("rogihy98ti}#~@]trfsd,godfsg8sdvjsdf", this.incidences.getImage());
    }
}
