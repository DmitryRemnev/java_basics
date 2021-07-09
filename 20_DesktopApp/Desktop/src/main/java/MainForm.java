import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class MainForm {
    public static final String ERROR = "Ошибка!";
    public static final String ENTER_DATA = "Введите данные!";

    private JPanel mainPanel;
    private JButton actionButton;
    private JTextField textFieldSurname;
    private JTextField textFieldName;
    private JTextField textFieldPatronymic;
    private JTextField textFieldAll;

    private String allText;
    private boolean isCollapse = true;

    public MainForm() {

        textFieldAll.setVisible(false);

        actionButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isCollapse) {
                    String textSurname = textFieldSurname.getText();
                    String textName = textFieldName.getText();

                    if (textSurname.isEmpty() || textName.isEmpty()) {
                        showDialog();
                    } else {
                        allText = textSurname + " " + textName + " " + textFieldPatronymic.getText();
                        textFieldAll.setVisible(true);
                        textFieldAll.setText(allText);

                        actionButton.setText("Expand");

                        textFieldSurname.setVisible(false);
                        textFieldName.setVisible(false);
                        textFieldPatronymic.setVisible(false);

                        isCollapse = false;
                    }

                } else {
                    allText = textFieldAll.getText();

                    if (allText.isEmpty()) {
                        showDialog();
                    } else {
                        TextUtil.divideText(allText.trim());

                        textFieldSurname.setVisible(true);
                        textFieldName.setVisible(true);
                        textFieldPatronymic.setVisible(true);

                        textFieldSurname.setText(TextUtil.surname);
                        textFieldName.setText(TextUtil.name);
                        textFieldPatronymic.setText(TextUtil.patronymic);

                        actionButton.setText("Collapse");

                        textFieldAll.setVisible(false);

                        isCollapse = true;
                    }
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void showDialog() {
        JOptionPane.showMessageDialog(
                mainPanel,
                ENTER_DATA,
                ERROR,
                JOptionPane.PLAIN_MESSAGE
        );
    }
}