import javax.swing.*;

public class editFigure
{
    private JLabel lbl_surname;
    private JTextField txt_surname;
    private JLabel lbl_firstname;
    private JLabel lbl_birthyear;
    private JLabel lbl_deathyear;
    private JTextField txt_firstname;
    private JTextField txt_bYear;
    private JTextField txt_dYear;
    private JButton btn_Search;
    private JButton btn_DeleteFig;
    private JButton btn_edit;
    private JButton btn_save;
    private JPanel editFig;
    private JTextField txt_details;
    private JLabel lbl_detail;
    static JFrame frame = new JFrame("editFigure");


    public static void editFigSet(){
        frame.setContentPane(new editFigure().editFig);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
