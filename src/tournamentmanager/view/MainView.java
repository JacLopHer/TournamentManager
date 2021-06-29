/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentmanager.view;

import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tournamentmanager.managers.LoginManager;
import tournamentmanager.managers.PlayerManager;
import tournamentmanager.entities.Admin;
import tournamentmanager.entities.Player;
import static tournamentmanager.managers.PlayerManager.*;
import tournamentmanager.managers.TournamentManager;
import tournamentmanager.entities.Tournament;
import tournamentmanager.managers.ListManager;
import static tournamentmanager.view.ValidationMethods.*;

/**
 *
 * @author Jacinto López Hernández
 */
public class MainView extends javax.swing.JFrame {

    public static tournamentmanager.database.MySQLConnector mySqlConnector;
    private Image img;
    public static ArrayList<Player> players;
    public static ArrayList<Tournament> tournaments;
    public TournamentManager tournamentManager;
    public PlayerManager playerManager;
    public tournamentmanager.managers.ListManager listManager;

    /**
     * Creates new form MainView
     */
    public MainView() {
        initAppIcon();
        initComponents();
        initConnection();
        initLoginDialog();
        this.setLocationRelativeTo(null);
        initArrayLists();
    }

    private void initArrayLists() {
        playerManager = new PlayerManager();
        players = playerManager.getPlayers();
        tournamentManager = new TournamentManager();
        tournaments = tournamentManager.getTournaments();
        TournamentTable.setModel(new TournamentsLoader(tournaments).getTournamentsModel());
        setCellsAlignment(TournamentTable, SwingConstants.CENTER);
        listManager = new ListManager();
    }

    /**
     * initializes the login form dialog
     */
    private void initLoginDialog() {
        jDialogLogin.setLocationRelativeTo(this);
        jDialogLogin.requestFocusInWindow();
        jDialogLogin.setVisible(true);
    }

    private void initAppIcon() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        img = kit.getImage(JFrame.class.getResource("/resources/images/luditorum_icon.png"));
        setIconImage(img);
    }

    /**
     * initializes the MySQL connection
     */
    private void initConnection() {
        mySqlConnector = tournamentmanager.database.ConnectionWrapper.initConnection();
    }

    /**
     * Sets the Look And Feel of the application to the one selected by the user
     *
     * @param index theme
     */
    private void setTheme(int index) {
        LookAndFeel laf = UIManager.getLookAndFeel();

        switch (index) {
            case 0:
                laf = new com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme();
                break;
            case 1:
                laf = new com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme();
                break;
            case 2:
                laf = new com.formdev.flatlaf.intellijthemes.FlatGradiantoNatureGreenIJTheme();
                break;
            case 3:
                laf = new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme();
                break;
            case 4:
                laf = new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme();
                break;
        }
        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(this);
        SwingUtilities.updateComponentTreeUI(jDialogHelp);
        SwingUtilities.updateComponentTreeUI(jDialogSettings);
        SwingUtilities.updateComponentTreeUI(jDialogVersion);
        SwingUtilities.updateComponentTreeUI(jDialogLogin);
        SwingUtilities.updateComponentTreeUI(jDialogAddPlayer);
    }

    /**
     * Closes the application
     */
    public void closeApplication() {
        mySqlConnector.cnxClose();
        System.exit(0);
    }

    /**
     * Logins into the application
     */
    public void login() {
        if (isInputEmpty(jTextFieldPwd) | isInputEmpty(jTextFieldLogin)) {
            jLabelLoginError.setVisible(true);
        } else {
            jLabelLoginError.setVisible(false);
            String user = jTextFieldLogin.getText();
            String pwd = jTextFieldPwd.getText();
            Admin admin = new Admin(user, pwd);
            if (LoginManager.checkLogin(admin)) {
                this.setLocationRelativeTo(null);
                this.setVisible(true);
                this.requestFocusInWindow();
                jDialogLogin.setVisible(false);
            } else {
                jLabelLoginError.setVisible(true);
            }
        }
    }

    /**
     * Checks wether the input field is empty or not
     *
     * @param jtxt
     * @return true - if it's empty, false otherwise
     */
    private boolean createPlayer() {
        String name = jTextFieldName1.getText();
        String nickname = jTextFieldNickname1.getText();
        String faction = (String)jComboBoxFactions.getSelectedItem();
        String list;
        Player newPlayer = new Player(name, nickname, faction);
        return false;
    }

    
    private boolean hasPlayerInput() {
        JTextField [] playerInputs = {jTextFieldName1,jTextFieldNickname1,jTextFieldPlayerList1};
        for(JTextField input : playerInputs){
            if(input.getText().equals("")){
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogLogin = new javax.swing.JDialog();
        jLabelLoginUser = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jTextFieldPwd = new javax.swing.JTextField();
        jLabelLoginPassword = new javax.swing.JLabel();
        jButtonConnect = new javax.swing.JButton();
        jButtonDialogClose = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabelLoginError = new javax.swing.JLabel();
        jDialogHelp = new javax.swing.JDialog();
        jLabelHelpLabel = new javax.swing.JLabel();
        jButtonHelpOk = new javax.swing.JButton();
        jDialogVersion = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jButtonOkVersion = new javax.swing.JButton();
        jDialogSettings = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxThemes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButtonSettingsExit = new javax.swing.JButton();
        jDialogNewTournament = new javax.swing.JDialog();
        jLabelAddModifyTournament = new javax.swing.JLabel();
        jButtonExitCreateTournament = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jButtonCreateTournament = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableNewTournamentPlayers = new javax.swing.JTable();
        jButtonAddTournamentPlayer = new javax.swing.JButton();
        jButtonUpdateTournament = new javax.swing.JButton();
        jLabelNumRounds = new javax.swing.JLabel();
        jSpinnerRoundsNum = new javax.swing.JSpinner();
        jDialogPlayers = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTablePlayers = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jDialogListNotValidError = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButtonErrorListDialog = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jDialogAddPlayer = new javax.swing.JDialog();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldNickname1 = new javax.swing.JTextField();
        jTextFieldName1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldPlayerList1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBoxFactions = new javax.swing.JComboBox<>();
        jButtonAddPlayer1 = new javax.swing.JButton();
        jButtonExitAddPlayer1 = new javax.swing.JButton();
        jLabelListHolder = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TournamentTable = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonNewTourney = new javax.swing.JButton();
        jButtonPlayers = new javax.swing.JButton();
        jButtonEditTourney = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemLoad = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemAddPlayer = new javax.swing.JMenuItem();
        jMenuItemAddRound = new javax.swing.JMenuItem();
        jMenuTools = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuAbout = new javax.swing.JMenu();
        jMenuItemHelp = new javax.swing.JMenuItem();
        jMenuItemVersion = new javax.swing.JMenuItem();

        jDialogLogin.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogLogin.setTitle("LOGIN");
        jDialogLogin.setIconImage(img);
        jDialogLogin.setModal(true);
        jDialogLogin.setResizable(false);
        jDialogLogin.setSize(new java.awt.Dimension(424, 270));
        jDialogLogin.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialogLoginWindowClosed(evt);
            }
        });

        jLabelLoginUser.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabelLoginUser.setText("USER");

        jTextFieldLogin.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextFieldLogin.setText("super_admin");
        jTextFieldLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldLoginKeyPressed(evt);
            }
        });

        jTextFieldPwd.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextFieldPwd.setText("changeme");
        jTextFieldPwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldLoginKeyPressed(evt);
            }
        });

        jLabelLoginPassword.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabelLoginPassword.setText("PASSWORD");

        jButtonConnect.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jButtonConnect.setText("Connect");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        jButtonDialogClose.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jButtonDialogClose.setText("Exit");
        jButtonDialogClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDialogCloseActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/title_250.png"))); // NOI18N

        jLabelLoginError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/error60.png"))); // NOI18N
        jLabelLoginError.setVisible(false);

        javax.swing.GroupLayout jDialogLoginLayout = new javax.swing.GroupLayout(jDialogLogin.getContentPane());
        jDialogLogin.getContentPane().setLayout(jDialogLoginLayout);
        jDialogLoginLayout.setHorizontalGroup(
            jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogLoginLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonDialogClose, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogLoginLayout.createSequentialGroup()
                        .addGroup(jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogLoginLayout.createSequentialGroup()
                                .addGroup(jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jDialogLoginLayout.createSequentialGroup()
                                        .addComponent(jLabelLoginPassword)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDialogLoginLayout.createSequentialGroup()
                                        .addComponent(jLabelLoginUser)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButtonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(jLabelLoginError))
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogLoginLayout.setVerticalGroup(
            jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(33, 33, 33)
                .addGroup(jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogLoginLayout.createSequentialGroup()
                        .addGroup(jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLoginUser))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLoginPassword)))
                    .addComponent(jLabelLoginError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDialogClose)
                    .addComponent(jButtonConnect))
                .addGap(18, 18, 18))
        );

        jDialogHelp.setTitle("HELP");
        jDialogHelp.setIconImage(img);
        jDialogHelp.setModal(true);
        jDialogHelp.setResizable(false);
        jDialogHelp.setSize(new java.awt.Dimension(246, 180));

        jLabelHelpLabel.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabelHelpLabel.setText("<html>This application was built by <br/><b> Jacinto López Hernández </b><br/><br/>\nFor further information<br/> <a href=\"mailto:jacilopezwork@gmail.com\">jacilopezwork@gmail.com</a><br/></html>");
        jLabelHelpLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButtonHelpOk.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButtonHelpOk.setText("OK");
        jButtonHelpOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogHelpLayout = new javax.swing.GroupLayout(jDialogHelp.getContentPane());
        jDialogHelp.getContentPane().setLayout(jDialogHelpLayout);
        jDialogHelpLayout.setHorizontalGroup(
            jDialogHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonHelpOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelHelpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialogHelpLayout.setVerticalGroup(
            jDialogHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHelpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButtonHelpOk)
                .addContainerGap())
        );

        jDialogVersion.setTitle("VERSION");
        jDialogVersion.setIconImage(img);
        jDialogVersion.setModal(true);
        jDialogVersion.setResizable(false);
        jDialogVersion.setSize(new java.awt.Dimension(221, 149));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Version : 1.00");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButtonOkVersion.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButtonOkVersion.setText("OK");
        jButtonOkVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkVersionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogVersionLayout = new javax.swing.GroupLayout(jDialogVersion.getContentPane());
        jDialogVersion.getContentPane().setLayout(jDialogVersionLayout);
        jDialogVersionLayout.setHorizontalGroup(
            jDialogVersionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogVersionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogVersionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonOkVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialogVersionLayout.setVerticalGroup(
            jDialogVersionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogVersionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jButtonOkVersion)
                .addContainerGap())
        );

        jDialogSettings.setTitle("SETTINGS");
        jDialogSettings.setIconImage(img);
        jDialogSettings.setResizable(false);
        jDialogSettings.setSize(new java.awt.Dimension(400, 350));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel4.setText("Theme");

        jComboBoxThemes.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jComboBoxThemes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arc Orange", "Arc Dark Orange", "Nature Green", "GitHub", "GitHub dark" }));
        jComboBoxThemes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxThemesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxThemes, 0, 280, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxThemes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SETTINGS");

        jButtonSettingsExit.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButtonSettingsExit.setText("Exit");
        jButtonSettingsExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSettingsExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogSettingsLayout = new javax.swing.GroupLayout(jDialogSettings.getContentPane());
        jDialogSettings.getContentPane().setLayout(jDialogSettingsLayout);
        jDialogSettingsLayout.setHorizontalGroup(
            jDialogSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSettingsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSettingsExit)))
                .addContainerGap())
        );
        jDialogSettingsLayout.setVerticalGroup(
            jDialogSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSettingsExit)
                .addContainerGap())
        );

        jDialogNewTournament.setTitle("NEW TOURNAMENT");
        jDialogNewTournament.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        jDialogNewTournament.setModal(true);
        jDialogNewTournament.setResizable(false);
        jDialogNewTournament.setSize(new java.awt.Dimension(807, 600));

        jLabelAddModifyTournament.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabelAddModifyTournament.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddModifyTournament.setText("NEW TOURNAMENT");

        jButtonExitCreateTournament.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonExitCreateTournament.setText("Exit");
        jButtonExitCreateTournament.setToolTipText("");
        jButtonExitCreateTournament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitCreateTournamentActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel12.setText("Name");

        jTextField1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTextField1.setToolTipText("Introduce the tournament's name");

        jLabel13.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel13.setText("Players");

        jSpinner1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(8, 4, 160, 1));
        jSpinner1.setToolTipText("Amount of players");

        jLabel14.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel14.setText("Date");

        jButtonCreateTournament.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonCreateTournament.setText("Create");
        jButtonCreateTournament.setToolTipText("Creates the tournament");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel5.setText("Players");

        jTableNewTournamentPlayers.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTableNewTournamentPlayers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableNewTournamentPlayers);

        jButtonAddTournamentPlayer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonAddTournamentPlayer.setText("Add Player");
        jButtonAddTournamentPlayer.setToolTipText("Adds a player to the current Tournament's Player pool");
        jButtonAddTournamentPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTournamentPlayerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAddTournamentPlayer)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddTournamentPlayer)
                .addContainerGap())
        );

        jButtonUpdateTournament.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonUpdateTournament.setText("Update");
        jButtonUpdateTournament.setToolTipText("Updates the current tournament");

        jLabelNumRounds.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabelNumRounds.setText("Rounds");

        jSpinnerRoundsNum.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jSpinnerRoundsNum.setModel(new javax.swing.SpinnerNumberModel(3, 3, 7, 1));
        jSpinnerRoundsNum.setToolTipText("Number of rounds the tournament will have");

        javax.swing.GroupLayout jDialogNewTournamentLayout = new javax.swing.GroupLayout(jDialogNewTournament.getContentPane());
        jDialogNewTournament.getContentPane().setLayout(jDialogNewTournamentLayout);
        jDialogNewTournamentLayout.setHorizontalGroup(
            jDialogNewTournamentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNewTournamentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogNewTournamentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAddModifyTournament, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogNewTournamentLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonUpdateTournament)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCreateTournament)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExitCreateTournament, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogNewTournamentLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNumRounds)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerRoundsNum, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialogNewTournamentLayout.setVerticalGroup(
            jDialogNewTournamentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNewTournamentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAddModifyTournament)
                .addGap(22, 22, 22)
                .addGroup(jDialogNewTournamentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumRounds)
                    .addComponent(jSpinnerRoundsNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jDialogNewTournamentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExitCreateTournament)
                    .addComponent(jButtonCreateTournament)
                    .addComponent(jButtonUpdateTournament))
                .addContainerGap())
        );

        jDialogPlayers.setSize(new java.awt.Dimension(639, 531));

        jTablePlayers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTablePlayers);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialogPlayersLayout = new javax.swing.GroupLayout(jDialogPlayers.getContentPane());
        jDialogPlayers.getContentPane().setLayout(jDialogPlayersLayout);
        jDialogPlayersLayout.setHorizontalGroup(
            jDialogPlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogPlayersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDialogPlayersLayout.setVerticalGroup(
            jDialogPlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogPlayersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogPlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                .addContainerGap())
        );

        jDialogListNotValidError.setTitle("Error Invalid List");
        jDialogListNotValidError.setModal(true);
        jDialogListNotValidError.setSize(new java.awt.Dimension(304, 165));

        jLabel15.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel15.setText("The selected file isn't a valid ");

        jButtonErrorListDialog.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jButtonErrorListDialog.setText("OK");
        jButtonErrorListDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonErrorListDialogActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel16.setText("roster txt from battlescribe.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButtonErrorListDialog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButtonErrorListDialog)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialogListNotValidErrorLayout = new javax.swing.GroupLayout(jDialogListNotValidError.getContentPane());
        jDialogListNotValidError.getContentPane().setLayout(jDialogListNotValidErrorLayout);
        jDialogListNotValidErrorLayout.setHorizontalGroup(
            jDialogListNotValidErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogListNotValidErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogListNotValidErrorLayout.setVerticalGroup(
            jDialogListNotValidErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogListNotValidErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialogAddPlayer.setTitle("PLAYER");
        jDialogAddPlayer.setIconImage(img);
        jDialogAddPlayer.setModal(true);
        jDialogAddPlayer.setSize(new java.awt.Dimension(475, 333));

        jLabel17.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ADD PLAYER");

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel18.setText("Name");

        jLabel19.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel19.setText("Nickname");

        jLabel20.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel20.setText("Faction");

        jTextFieldNickname1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N

        jTextFieldName1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel21.setText("List");

        jTextFieldPlayerList1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTextFieldPlayerList1.setFocusable(false);

        jButton2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jButton2.setText("List...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBoxFactions.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jComboBoxFactions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adeptus Mechanicus", "Adeptas Sororitas", "Astra Militarum", "Black Templars", "Blood Angels", "Chaos Knights", "Chaos Space Marines ", "Craftworlds", "Crimson Fist", "Custodes", "Daemons", "Dark Angels", "Death Guard", "Death Watch ", "Drukhari", "Genestealer's Cult", "Grey Knights", "Imperial Fist", "Imperial Knights", "Ironhands", "Harlequins", "Necrons ", "Orks", "Raven Guard", "Salamanders", "Space Marines", "Space Wolves", "Tau ", "Thousand Sons", "Tyranids", "Ultramarines", "White Scar ", "Ynnari" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNickname1)
                    .addComponent(jTextFieldName1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextFieldPlayerList1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jComboBoxFactions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldNickname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldPlayerList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFactions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonAddPlayer1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jButtonAddPlayer1.setText("Add");
        jButtonAddPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPlayer1ActionPerformed(evt);
            }
        });

        jButtonExitAddPlayer1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jButtonExitAddPlayer1.setText("Exit");
        jButtonExitAddPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitAddPlayer1ActionPerformed(evt);
            }
        });

        jLabelListHolder.setVisible(false);

        javax.swing.GroupLayout jDialogAddPlayerLayout = new javax.swing.GroupLayout(jDialogAddPlayer.getContentPane());
        jDialogAddPlayer.getContentPane().setLayout(jDialogAddPlayerLayout);
        jDialogAddPlayerLayout.setHorizontalGroup(
            jDialogAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAddPlayerLayout.createSequentialGroup()
                        .addComponent(jLabelListHolder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAddPlayer1)
                        .addGap(15, 15, 15)
                        .addComponent(jButtonExitAddPlayer1)))
                .addContainerGap())
        );
        jDialogAddPlayerLayout.setVerticalGroup(
            jDialogAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialogAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogAddPlayerLayout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jDialogAddPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddPlayer1)
                            .addComponent(jButtonExitAddPlayer1))
                        .addContainerGap())
                    .addGroup(jDialogAddPlayerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelListHolder)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TOURNAMENT MANAGER");

        jPanel1.setPreferredSize(new java.awt.Dimension(652, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/title_600.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 0));

        TournamentTable.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TournamentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TournamentTable.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane1.setViewportView(TournamentTable);

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        jButtonNewTourney.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jButtonNewTourney.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/new-document-icon.png"))); // NOI18N
        jButtonNewTourney.setToolTipText("Create a new tournament");
        jButtonNewTourney.setFocusable(false);
        jButtonNewTourney.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNewTourney.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNewTourney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewTourneyActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonNewTourney);

        jButtonPlayers.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jButtonPlayers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Sport-Football-Player-Male-Light-icon.png"))); // NOI18N
        jButtonPlayers.setToolTipText("Players");
        jButtonPlayers.setFocusable(false);
        jButtonPlayers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPlayers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayersActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonPlayers);

        jButtonEditTourney.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jButtonEditTourney.setText("Tourneys");
        jButtonEditTourney.setToolTipText("Edit tournament");
        jButtonEditTourney.setFocusable(false);
        jButtonEditTourney.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEditTourney.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButtonEditTourney);

        jButton4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButtonClose.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButtonClose.setText("Exit");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jMenuFile.setText("File");
        jMenuFile.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        jMenuItemNew.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jMenuItemNew.setText("New...");
        jMenuFile.add(jMenuItemNew);

        jMenuItemLoad.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jMenuItemLoad.setText("Load...");
        jMenuFile.add(jMenuItemLoad);

        jMenuItemExit.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBar1.add(jMenuFile);

        jMenuEdit.setText("Edit");
        jMenuEdit.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        jMenuItemAddPlayer.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jMenuItemAddPlayer.setText("Add Player...");
        jMenuItemAddPlayer.setToolTipText("");
        jMenuItemAddPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddPlayerActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemAddPlayer);

        jMenuItemAddRound.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jMenuItemAddRound.setText("Add Round...");
        jMenuEdit.add(jMenuItemAddRound);

        jMenuBar1.add(jMenuEdit);

        jMenuTools.setText("Tools");
        jMenuTools.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jMenuItem1.setText("Settings");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuTools.add(jMenuItem1);

        jMenuBar1.add(jMenuTools);

        jMenuAbout.setText("About");
        jMenuAbout.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        jMenuItemHelp.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jMenuItemHelp.setText("Help");
        jMenuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHelpActionPerformed(evt);
            }
        });
        jMenuAbout.add(jMenuItemHelp);

        jMenuItemVersion.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jMenuItemVersion.setText("Version");
        jMenuItemVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVersionActionPerformed(evt);
            }
        });
        jMenuAbout.add(jMenuItemVersion);

        jMenuBar1.add(jMenuAbout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        closeApplication();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        closeApplication();
    }//GEN-LAST:event_jMenuItemExitActionPerformed


    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        login();
    }//GEN-LAST:event_jButtonConnectActionPerformed

    private void jButtonDialogCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDialogCloseActionPerformed
        jDialogLogin.dispose();
        closeApplication();
    }//GEN-LAST:event_jButtonDialogCloseActionPerformed

    private void jDialogLoginWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogLoginWindowClosed
        closeApplication();
    }//GEN-LAST:event_jDialogLoginWindowClosed

    private void jTextFieldLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_jTextFieldLoginKeyPressed

    private void jButtonHelpOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpOkActionPerformed
        jDialogHelp.dispose();
    }//GEN-LAST:event_jButtonHelpOkActionPerformed

    private void jMenuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpActionPerformed
        jDialogHelp.setLocationRelativeTo(null);
        jDialogHelp.setVisible(true);
    }//GEN-LAST:event_jMenuItemHelpActionPerformed

    private void jMenuItemVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVersionActionPerformed
        jDialogVersion.setLocationRelativeTo(null);
        jDialogVersion.setVisible(true);
    }//GEN-LAST:event_jMenuItemVersionActionPerformed

    private void jButtonOkVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkVersionActionPerformed
        jDialogVersion.dispose();
    }//GEN-LAST:event_jButtonOkVersionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jDialogSettings.setLocationRelativeTo(null);
        jDialogSettings.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonSettingsExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSettingsExitActionPerformed
        jDialogSettings.dispose();
    }//GEN-LAST:event_jButtonSettingsExitActionPerformed

    private void jComboBoxThemesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxThemesActionPerformed
        int theme_index = jComboBoxThemes.getSelectedIndex();
        setTheme(theme_index);
    }//GEN-LAST:event_jComboBoxThemesActionPerformed

    private void jMenuItemAddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddPlayerActionPerformed
        jDialogAddPlayer.setLocationRelativeTo(null);
        jDialogAddPlayer.setVisible(true);
    }//GEN-LAST:event_jMenuItemAddPlayerActionPerformed

    private void jButtonNewTourneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewTourneyActionPerformed
        jDialogNewTournament.setVisible(true);
    }//GEN-LAST:event_jButtonNewTourneyActionPerformed

    private void jButtonPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayersActionPerformed
        DefaultTableModel dlm = new PlayersLoader(players).getModelPlayers();
        jTablePlayers.setModel(dlm);
        jDialogPlayers.setVisible(true);
    }//GEN-LAST:event_jButtonPlayersActionPerformed

    private void jButtonExitCreateTournamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitCreateTournamentActionPerformed
        jDialogNewTournament.dispose();
    }//GEN-LAST:event_jButtonExitCreateTournamentActionPerformed

    private void jButtonAddTournamentPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTournamentPlayerActionPerformed
        jTextFieldPlayerList1.setText("");
        jTextFieldName1.setText("");
        jTextFieldNickname1.setText("");
        jDialogAddPlayer.setVisible(true);
    }//GEN-LAST:event_jButtonAddTournamentPlayerActionPerformed

    private void jButtonErrorListDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonErrorListDialogActionPerformed
        jDialogListNotValidError.dispose();
    }//GEN-LAST:event_jButtonErrorListDialogActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files","txt");
        chooser.addChoosableFileFilter(filter);
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(jDialogAddPlayer);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (isListValid(file)) {
                jTextFieldPlayerList1.setText(file.getName());
                jLabelListHolder.setText(file.getAbsolutePath());
            } else {
                jDialogListNotValidError.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonAddPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPlayer1ActionPerformed
        if (hasPlayerInput()) {
            String name = jTextFieldName1.getText();
            String nickname = jTextFieldNickname1.getText();
            String faction = (String)jComboBoxFactions.getSelectedItem();
            String list = listManager.getPlayerList(new File (jLabelListHolder.getText()));
            Player newPlayer = new Player(name, nickname, faction, list);
            if(isPlayerLoaded(newPlayer)){
                System.out.println(newPlayer.toString());
            }
        }
    }//GEN-LAST:event_jButtonAddPlayer1ActionPerformed

    private void jButtonExitAddPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitAddPlayer1ActionPerformed
        jDialogAddPlayer.dispose();
    }//GEN-LAST:event_jButtonExitAddPlayer1ActionPerformed

    

    /**
     * Centers the table cell alignment to the designed aligment
     *
     * @param table
     * @param alignment
     */
    public static void setCellsAlignment(JTable table, int alignment) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.intellijthemes.FlatMaterialDesignDarkIJTheme());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TournamentTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAddPlayer1;
    private javax.swing.JButton jButtonAddTournamentPlayer;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonCreateTournament;
    private javax.swing.JButton jButtonDialogClose;
    private javax.swing.JButton jButtonEditTourney;
    private javax.swing.JButton jButtonErrorListDialog;
    private javax.swing.JButton jButtonExitAddPlayer1;
    private javax.swing.JButton jButtonExitCreateTournament;
    private javax.swing.JButton jButtonHelpOk;
    private javax.swing.JButton jButtonNewTourney;
    private javax.swing.JButton jButtonOkVersion;
    private javax.swing.JButton jButtonPlayers;
    private javax.swing.JButton jButtonSettingsExit;
    private javax.swing.JButton jButtonUpdateTournament;
    private javax.swing.JComboBox<String> jComboBoxFactions;
    private javax.swing.JComboBox<String> jComboBoxThemes;
    private javax.swing.JDialog jDialogAddPlayer;
    private javax.swing.JDialog jDialogHelp;
    private javax.swing.JDialog jDialogListNotValidError;
    private javax.swing.JDialog jDialogLogin;
    private javax.swing.JDialog jDialogNewTournament;
    private javax.swing.JDialog jDialogPlayers;
    private javax.swing.JDialog jDialogSettings;
    private javax.swing.JDialog jDialogVersion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAddModifyTournament;
    private javax.swing.JLabel jLabelHelpLabel;
    private javax.swing.JLabel jLabelListHolder;
    private javax.swing.JLabel jLabelLoginError;
    private javax.swing.JLabel jLabelLoginPassword;
    private javax.swing.JLabel jLabelLoginUser;
    private javax.swing.JLabel jLabelNumRounds;
    private javax.swing.JMenu jMenuAbout;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemAddPlayer;
    private javax.swing.JMenuItem jMenuItemAddRound;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemHelp;
    private javax.swing.JMenuItem jMenuItemLoad;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemVersion;
    private javax.swing.JMenu jMenuTools;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinnerRoundsNum;
    private javax.swing.JTable jTableNewTournamentPlayers;
    private javax.swing.JTable jTablePlayers;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldName1;
    private javax.swing.JTextField jTextFieldNickname1;
    private javax.swing.JTextField jTextFieldPlayerList1;
    private javax.swing.JTextField jTextFieldPwd;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the img
     */
    public Image getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(Image img) {
        this.img = img;
    }
}
