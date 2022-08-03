package com.UDNDcourse1.springbootcourse.POJO;

public class ChatForm {
   private String userName;
   private String chatText;
   private String msgType;

   public ChatForm(String userName, String chatText, String msgType) {
      this.userName = userName;
      this.chatText = chatText;
      this.msgType = msgType;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getChatText() {
      return chatText;
   }

   public void setChatText(String chatText) {
      this.chatText = chatText;
   }

   public String getMsgType() {
      return msgType;
   }

   public void setMsgType(String msgType) {
      this.msgType = msgType;
   }

}
