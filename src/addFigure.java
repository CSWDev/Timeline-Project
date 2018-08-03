import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class addFigure {
    private JPanel addFigure;
    private JLabel lbl_HistoricalFig;
    private JLabel lbl_forename;
    private JLabel lbl_lastname;
    private JLabel lbl_dob;
    private JLabel lbl_deathyear;
    private JLabel lbl_Deets;
    private JTextField txt_firstname;
    private JTextField txt_lastname;
    private JTextField txt_yearbirth;
    private JTextField txt_yearDeath;
    private JTextField txt_details;
    private JButton btn_confirm;
    private JLabel lbl_image;
    private JButton btn_img;
    private JTextField txt_imgpath;
    private JButton btn_cancel;
    JFrame frame = new JFrame("addFigure");
    protected String firstname;
    protected String lastname;
    protected int dob;
    protected int dod;
    protected String details;
    protected String imgpath;
    final JFileChooser fc = new JFileChooser();

    public addFigure() {
        btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_firstname.getText().equals("") || txt_lastname.getText().equals("") || txt_details.getText().equals("") || txt_yearbirth.getText().equals("") || txt_yearDeath.getText().equals("") ){
                    JOptionPane.showMessageDialog(null, "Please enter details");

                }else{
                    sendData();
                }

            }
        });
        btn_img.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == btn_img){
                    int returnVal = fc.showOpenDialog(addFigure);

                    if (returnVal == JFileChooser.APPROVE_OPTION){
                        File file = fc.getSelectedFile();
                        txt_imgpath.setText(file.toString());

                    }else{
                        JOptionPane.showMessageDialog(null, "Cancelled");
                    }
                }
            }
        });
        txt_yearbirth.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        txt_yearDeath.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
    }

    public static void main(String[] args) {
            new addFigure().setAddFig();
    }

    public void setAddFig()
    {
        frame.setContentPane(new addFigure().addFigure);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void sendData(){
        firstname = txt_firstname.getText();
        lastname = txt_lastname.getText();
        dob = Integer.parseInt(txt_yearbirth.getText());
        dod = Integer.parseInt(txt_yearDeath.getText());
        details = txt_details.getText();

        Figure figure = new Figure(firstname, lastname, dob, dod,details);

        dataHandle.figures.add(figure);

        try {
            dataHandle.saveFigureToFile();
            JOptionPane.showMessageDialog(null,"Figure Added");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
