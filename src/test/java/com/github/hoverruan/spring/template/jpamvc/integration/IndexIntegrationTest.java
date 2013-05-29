package com.github.hoverruan.spring.template.jpamvc.integration;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.junit.internal.matchers.StringContains.containsString;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class IndexIntegrationTest {
    private Random random = new Random();

    @Test
    public void should_create_Book_success() throws IOException {
        String bookName = "BookName" + random.nextInt(1000000);
        HttpResponse response = Request.Get("http://localhost:8080/?name=" + bookName).execute().returnResponse();

        assertThat(response.getStatusLine().getStatusCode(), is(HttpServletResponse.SC_OK));

        HttpEntity body = response.getEntity();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        body.writeTo(baos);

        assertThat(baos.toString(), containsString(bookName));
    }
}
