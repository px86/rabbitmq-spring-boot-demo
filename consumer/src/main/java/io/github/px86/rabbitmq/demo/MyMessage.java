package io.github.px86.rabbitmq.demo;

import java.util.Date;

public class MyMessage {
  private String id;
  private String body;
  private Date date;

  public MyMessage() {}

  public MyMessage(String id, String body, Date date) {
    this.id = id;
    this.body = body;
    this.date = date;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "MyMessage [id=" + id + ", body=" + body + ", date=" + date + "]";
  }
}
