import jdk.nashorn.internal.scripts.JO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class createAcc {
    public JPanel createAccpanel;
    private JButton btn_confirm;
    private JButton btn_cancel;
    private JTextField txt_username;
    private JTextField txt_lastname;
    private JTextField txt_firstname;
    private JLabel lbl_firstname;
    private JLabel lbl_lastname;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JPasswordField ptxt_password;
    private JPasswordField ptxt_password2;
    private JLabel lbl_password2;
    private JLabel lbl_newusericon;
    JFrame frame = new JFrame("createAcc");

    protected String firstname;
    protected String lastname;
    protected String username;
    protected String password;
    protected String password2;


   public createAcc() {

       btn_cancel.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               new loginMain().formSetup();
           }
       });
       btn_confirm.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                if (txt_firstname.getText().equals("") || txt_lastname.getText().equals("") || txt_username.getText().equals("") || ptxt_password.getText().equals("") || ptxt_password2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter values");
                } else{
                    createUser();
                }
           }
       });
   }

    public static void main(String[] args) {
         new createAcc().setCreateAccpanel();


    }

    public void setCreateAccpanel(){
        frame.setContentPane(new createAcc().createAccpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
                lbl_newusericon = new JLabel(new ImageIcon("images/newuser.png"));
            }

    private void createUser(){
        firstname = txt_firstname.getText();
        lastname = txt_lastname.getText();
        username = txt_username.getText();
        password = ptxt_password.getText();
        password2 = ptxt_password2.getText();

        if (password.equals(password2))
        {
            superUser spr = new superUser();
            spr.setFirstname(firstname);
            spr.setLastname(lastname);
            spr.setPassword(password);
            spr.setUsername(username);

            dataHandle.users.add(spr);
            try {
                dataHandle.saveUsersToFile();
                JOptionPane.showMessageDialog(null,"Created account");
                //this.dispose();
                new loginMain().formSetup();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Password must match");
        }

    }
}