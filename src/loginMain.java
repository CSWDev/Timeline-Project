import javax.swing.*;

import org.json.JSONException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.ArrayList;

public class loginMain
{
    public static JFrame frame = new JFrame("Login Menu");
    public JPanel loginMain;
    private JTextField textField1;
    private JPasswordField txtbx_passwordField;
    private JButton btn_login;
    private JLabel imageLogo;
    private JButton btn_createAcc;
    private String crtr1;
    static ArrayList<superUser> credentials = new ArrayList<>();


    public loginMain()
    {
        btn_createAcc.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new createAcc().setCreateAccpanel();
            }
        });
        btn_login.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                credentials();
            }
        });
    }

    public static void main(String[] args)
    {
        formSetup();
    }

    public void createUIComponents()
    {
        imageLogo = new JLabel(new ImageIcon("images/logo.png"));
    }

    public static void formSetup()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new loginMain().loginMain);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public void credentials()
    {
        dataHandle.readUsernameFromFile();
        String username = textField1.getText();
        String password = txtbx_passwordField.getText();
        int loginCheck = 0;

        for (int i = 0; i < credentials.size(); i++)
        {
            String usrnm = credentials.get(i).getUsername();
            String pass = credentials.get(i).getPassword();
            if (usrnm.equals(username) && password.equals(pass))
            {
                loginCheck = 1;
                break;
            }

        }
        if (loginCheck == 1)
        {
            frame.dispose();
            mainForm.setMainForm();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Credentials error");
        }
    }
}

//had password hashing but struggled to use it in login in a user
//            try {
//                // Create MessageDigest instance for MD5
//                MessageDigest md = MessageDigest.getInstance("MD5");
//                //Add password bytes to digest
//                md.update(rtPass.getBytes());
//                //Get the hash's bytes
//                byte[] bytes = md.digest();
//                //This bytes[] has bytes in decimal format;
//                //Convert it to hexadecimal format
//                StringBuilder sb = new StringBuilder();
//                for(int s=0; s< bytes.length ;s++)
//                {
//                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//                }
//                rtPass = sb.toString();
//            }
//            catch (NoSuchAlgorithmException aq)
//            {
//                aq.printStackTrace();
//            }