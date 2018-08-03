import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class viewFigures
{
    private JLabel lbl_forename;
    private JLabel lbl_surname;
    private JLabel lbl_dob;
    private JLabel lbl_dod;
    private JLabel lbl_details;
    private JTextField txt_firstname;
    private JTextField txt_lastname;
    private JTextField txt_dob;
    private JTextField txt_dod;
    private JTextField txt_details;
    private JSlider slider1;
    private JPanel viewFigures;
    static ArrayList<Figure>aFigure = new ArrayList<>();


    public viewFigures()
    {
        slider1.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                dataHandle.readFigureFromFile();
                txt_firstname.setText("");
                txt_lastname.setText("");
                txt_dob.setText("");
                txt_dod.setText("");
                txt_details.setText("");
                for (int i = 0; i < aFigure.size(); i++){
                    int DB = aFigure.get(i).getDOB();
                    int CD = slider1.getValue();

                    if (DB == CD){
                        txt_firstname.setText(aFigure.get(i).getFirstname());
                        txt_lastname.setText(aFigure.get(i).getLastname());
                        txt_dob.setText(String.valueOf(aFigure.get(i).getDOB()));
                        txt_dod.setText(String.valueOf(aFigure.get(i).getDOD()));
                        txt_details.setText(aFigure.get(i).getDetails());

                    }
                }
            }
        });
    }

    public static void setViewFigures(){
        JFrame frame = new JFrame("viewFigures");
        frame.setContentPane(new viewFigures().viewFigures);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }
}
