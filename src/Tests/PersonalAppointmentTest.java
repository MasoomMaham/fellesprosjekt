package Tests;

import Model.PersonalAppointment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class PersonalAppointmentTest {
    PersonalAppointment appointmentTest = new PersonalAppointment();
    Calendar testDate = Calendar.getInstance();

//  Alle tester her kjøres inn i personalAppointment, som er referert i DatabaseServerklassen,
//  men er kommentert ut er på nåværende tidspunkt(3/2/2015 - 13:33).

//    Tester her det å sette en dato, og å se om den er lik når den kommer ut.
    @Test
    public void testSetDato() throws Exception {
        testDate.set(testDate.YEAR, 2015);
        testDate.set(testDate.MONTH, testDate.FEBRUARY);
        testDate.set(testDate.DATE, 13);

        testDate.set( testDate.HOUR_OF_DAY, 0 );
        testDate.set( testDate.MINUTE, 0 );
        testDate.set( testDate.SECOND, 0 );
        testDate.set( testDate.MILLISECOND, 0 );

        java.sql.Date tester = new java.sql.Date(testDate.getTime().getTime());

        appointmentTest.setDato(tester);

        assertEquals(tester,appointmentTest.getDato());
    }
//    Setter her startTiden, som et Time-objekt. Sjekker om den er riktig tilbake.
    @Test
    public void testSetStartTid() throws Exception {
        Time start = new Time(12, 00,00);
        appointmentTest.setStartTid(start);
        assertEquals(start , appointmentTest.getStartTid());
    }
//  Setter sluttid som et Time-objekt og ser om den er riktig når den kommer tilbake.
    @Test
    public void testSetSluttTid() throws Exception {
        Time end = new Time(12,30,00);
        appointmentTest.setSluttTid(end);
        assertEquals(end, appointmentTest.getSluttTid());
    }
//  Setter opp en beskrivelse og ser om denne er lik når den kommer tilbake.
    @Test
    public void testSetBeskrivelse() throws Exception {
        appointmentTest.setBeskrivelse("Testbeskrivelse");
        assertEquals("Testbeskrivelse",appointmentTest.getBeskrivelse());
    }
//  Setter opp et romnavn og ser om den er lik når den kommer tilbake.
    @Test
    public void testSetRomnavn() throws Exception {
        appointmentTest.setRomnavn("IT-vest 22");
        assertEquals("IT-vest 22", appointmentTest.getRomnavn());
    }
}