/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Conexion;
import Controlador.Control_alumnos;
import Controlador.Control_asignatura;
import Controlador.Control_aspirante;
import Controlador.Control_empresario;
import Controlador.Control_ficha;
import Controlador.Control_hoja;
import Modelo.alumnos;
import Modelo.asignatura;
import Modelo.aspirante;
import Modelo.empresario;
import Modelo.ficha_individual;
import Modelo.hoja_actividades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author ADMIN
 */
public class Sistema extends javax.swing.JFrame {
    
    int id_asig = 0;
    int id_emp = 0;
    int id_Alumno = 0;
    int id_ficha = 0;
    
    
    private final Control_alumnos CA = new Control_alumnos();
    private List<alumnos> a;
    alumnos al = new alumnos();
    
    
   private Control_asignatura CAsigna = new Control_asignatura();
   private List<asignatura> asig;
   asignatura asi = new asignatura();
   
   private Control_aspirante CAsp = new Control_aspirante();
   private List<aspirante> aps;
   aspirante aspi = new aspirante();
   
   private Control_empresario CEmpr = new Control_empresario();
   private List<empresario> emp;
   empresario empre = new empresario();
   
   private Control_ficha CFic = new Control_ficha();
   private  List<ficha_individual> fic;
   ficha_individual ficha = new ficha_individual();
   
   private Control_hoja CHoja = new Control_hoja();
   private List<hoja_actividades> hoja;
   hoja_actividades hojaA = new hoja_actividades();


   
    
    public Sistema() throws SQLException, ClassNotFoundException {
        initComponents();
        this.iniciarLista();
        this.iniciarListaAsignatura();
        this.iniciarListaAspi();
        this.iniciarListaEmp();
        this.iniciarListaFicha();
        this.iniciarListaHoja();
        jDateChooser2.setDate(this.ficha.getFecha());
        this.llenar_asignatura(Conexion.obtener(), listaAsignaturas);
        this.llenarFicha(Conexion.obtener(), jComboBox2);
        this.llenarEmpresarios(Conexion.obtener(), jComboBox7);
        this.setLocationRelativeTo(null);  
        
        
    }
    
   
    
    
    private void iniciarLista() {
        try {
            this.a = this.CA.recuperarTodas(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) jT.getModel();
            dtm.setRowCount(0);
            for (int i = 0; i < this.a.size(); i++) {
                dtm.addRow(new Object[]{
                    this.a.get(i).getIdAlumno(),
                    this.a.get(i).getNombre(),
                    this.a.get(i).getApellido(),
                    this.a.get(i).getDireccion(),
                    this.a.get(i).getNivel_Estudio(),
                    this.a.get(i).getTitulo(),
                    this.a.get(i).getIdGrupo(),
                    this.a.get(i).getIdFicha_Individual()
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de los alumnos.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de los alumnos");
        }
    }

    private void iniciarListaAsignatura() {
        try {
            this.asig = this.CAsigna.recuperarTodas(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) jTAs.getModel();
            dtm.setRowCount(0);
            for (int i = 0; i < this.asig.size(); i++) {
                dtm.addRow(new Object[]{
                    this.asig.get(i).getIdAsignatura(),
                    this.asig.get(i).getNombre()

                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de las asignatura.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de las asignaturas");
        }
    }

    private void iniciarListaAspi() {
        try {
            this.aps = this.CAsp.recuperarTodas(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) jTAsp.getModel();
            dtm.setRowCount(0);
            for (int i = 0; i < this.aps.size(); i++) {
                dtm.addRow(new Object[]{
                    this.aps.get(i).getIdAspirante(),
                    this.aps.get(i).getNombre(),
                    this.aps.get(i).getIdAsignatura()
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de los aspirante.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de los aspirante");
        }
    }

    private void iniciarListaEmp() {
        try {
            this.emp = this.CEmpr.recuperarTodas(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) jTEmpre.getModel();
            dtm.setRowCount(0);
            for (int i = 0; i < this.emp.size(); i++) {
                dtm.addRow(new Object[]{
                    this.emp.get(i).getIdEmpresario(),
                    this.emp.get(i).getNombre(),
                    this.emp.get(i).getApellido(),
                    this.emp.get(i).getCedula(),
                    this.emp.get(i).getDireccion(),
                    this.emp.get(i).getNivel_Estudio(),
                    this.emp.get(i).getTitulo()
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de los empresarios.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de los empresarios");
        }
    }

    private void iniciarListaFicha() {
        try {
            this.fic = this.CFic.recuperarTodas(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) jTFicha.getModel();
            dtm.setRowCount(0);
            for (int i = 0; i < this.fic.size(); i++) {
                dtm.addRow(new Object[]{
                    this.fic.get(i).getIdFicha_individual(),
                    this.fic.get(i).getFecha()
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de ficha individual.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de ficha individual");
        }
    }
    
    private void iniciarListaHoja(){
        try{
            this.hoja = this.CHoja.recuperarTodas(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) jTHoja.getModel();
            dtm.setRowCount(0);
            for(int i = 0; i < this.hoja.size(); i++){
                dtm.addRow(new Object[]{
                    this.hoja.get(i).getIdHoja_Actividades(),
                    this.hoja.get(i).getHora_Inicio(),
                    this.hoja.get(i).getHora_Final(),
                    this.hoja.get(i).getIdEmpresario()
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de la hoja actividades.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros de la hoja actividades");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnIrAlumno = new javax.swing.JButton();
        btnIrAsignatura = new javax.swing.JButton();
        btnIrAspirante = new javax.swing.JButton();
        btnIrEmpresario = new javax.swing.JButton();
        btnIrFicha = new javax.swing.JButton();
        btnIrHoja = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT = new javax.swing.JTable();
        btnGA = new javax.swing.JButton();
        btnMA = new javax.swing.JButton();
        btnEA = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtIdAsig = new javax.swing.JTextField();
        txtNombreAs = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAs = new javax.swing.JTable();
        btnAsigna = new javax.swing.JButton();
        btnAcA = new javax.swing.JButton();
        btnEAsig = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtAspirante = new javax.swing.JTextField();
        txtNombreAspi = new javax.swing.JTextField();
        listaAsignaturas = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAsp = new javax.swing.JTable();
        btnAspirante = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        btnBuscarAspirante = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtIdEmpre = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtNombreEmp = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtApellidoEmp = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtCedulaEmp = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtDirecEm = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtNivelEm = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtTituloEm = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTEmpre = new javax.swing.JTable();
        btnEmpresario = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        btnEliminarEmpresario = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        txtIdFicha = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTFicha = new javax.swing.JTable();
        btnGuardarFicha = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        btnEliminarFicha = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtIdHoja = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtHoraI = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtHoraF = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTHoja = new javax.swing.JTable();
        btnGHoja = new javax.swing.JButton();
        btnHojaE = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jComboBox14 = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnIrAlumno.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        btnIrAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/community_users_12977 (2).png"))); // NOI18N
        btnIrAlumno.setText("Alumnos");
        btnIrAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAlumnoActionPerformed(evt);
            }
        });

        btnIrAsignatura.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        btnIrAsignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1492531743-icon-sets-school-outline-hand-drawn-iconfinder02_83203.png"))); // NOI18N
        btnIrAsignatura.setText("Asignaturas");
        btnIrAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAsignaturaActionPerformed(evt);
            }
        });

        btnIrAspirante.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        btnIrAspirante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/team_people_work_icon_176863.png"))); // NOI18N
        btnIrAspirante.setText("Aspirantes");
        btnIrAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAspiranteActionPerformed(evt);
            }
        });

        btnIrEmpresario.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        btnIrEmpresario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Teachers512_44214 (3).png"))); // NOI18N
        btnIrEmpresario.setText("Empresario");
        btnIrEmpresario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrEmpresarioActionPerformed(evt);
            }
        });

        btnIrFicha.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        btnIrFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/checklist_pen_tab_list_tick_icon_188931.png"))); // NOI18N
        btnIrFicha.setText("Ficha Individual");
        btnIrFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrFichaActionPerformed(evt);
            }
        });

        btnIrHoja.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        btnIrHoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/folders_documents_9789.png"))); // NOI18N
        btnIrHoja.setText("Hoja Actividades");
        btnIrHoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrHojaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/4115235-exit-logout-sign-out_114030.png"))); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Captura_de_pantalla_2022-11-11_110538-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnIrAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnIrAspirante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnIrEmpresario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnIrFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnIrHoja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnIrAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIrAlumno)
                .addGap(21, 21, 21)
                .addComponent(btnIrAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIrAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIrEmpresario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIrFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIrHoja, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 690));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/peakpx (8).jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 960, 100));

        jPanel17.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel9.setText("Nombre");

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel10.setText("Apelllido");

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel2.setText("Direccion");

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel3.setText("Nivel Estudio");

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel4.setText("Titulo");

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel5.setText("Id Grupo");

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel6.setText("Id Ficha Individual");

        txtNombre.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        txtApellido.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        txtDireccion.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        txtNivel.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        txtTitulo.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar-", "234" }));

        jComboBox2.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar-" }));

        jT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Alumno", "Nombre", "Apellido", "Direccion", "Nivel Estudio", "Titulo", "Id Grupo", "Id Ficha Individual"
            }
        ));
        jT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jT);

        btnGA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGAActionPerformed(evt);
            }
        });

        btnMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAActionPerformed(evt);
            }
        });

        btnEA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel17Layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel17Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtApellido))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel17Layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtDireccion))
                                                .addGroup(jPanel17Layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 12, Short.MAX_VALUE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(btnGA, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(btnMA, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(btnEA, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGA, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMA, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEA, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", jPanel17);

        jPanel18.setBackground(new java.awt.Color(204, 204, 204));
        jPanel18.setForeground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel8.setText("Id Asignatura");

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel11.setText("Nombre");

        txtIdAsig.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        txtNombreAs.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jTAs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Asignatura", "Nombre"
            }
        ));
        jTAs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTAs);

        btnAsigna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnAsigna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignaActionPerformed(evt);
            }
        });

        btnAcA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnAcA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcAActionPerformed(evt);
            }
        });

        btnEAsig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEAsigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnAsigna, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreAs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnAcA, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAcA, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(btnAsigna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab2", jPanel18);

        jPanel19.setBackground(new java.awt.Color(204, 204, 204));

        jLabel12.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel12.setText("Id Aspirante");

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel13.setText("Nombre");

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel14.setText("Id Asignatura");

        txtAspirante.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtAspirante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAspiranteKeyPressed(evt);
            }
        });

        txtNombreAspi.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        listaAsignaturas.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        listaAsignaturas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar-" }));

        jTAsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Aspirante", "Nombre", "Id Asignatura"
            }
        ));
        jTAsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAspMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTAsp);

        btnAspirante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAspiranteActionPerformed(evt);
            }
        });

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        btnBuscarAspirante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/xmag_search_find_export_locate_5984.png"))); // NOI18N
        btnBuscarAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAspiranteActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/EmptyRecycleBinrecycleempty_VaciarPapeleradereciclaje_reciclar_1890.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel14)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreAspi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listaAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscarAspirante, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreAspi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listaAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", jPanel19);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab4", jPanel20);

        jLabel18.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel18.setText("Id Curso");

        jLabel19.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel19.setText("Numero Curso");

        jTable5.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Curso", "Numero Curso"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N

        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(jButton35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(156, 156, 156))
        );

        jTabbedPane2.addTab("tab6", jPanel22);

        jPanel23.setBackground(new java.awt.Color(204, 204, 204));

        jLabel20.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel20.setText("Id Empresario");

        txtIdEmpre.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel21.setText("Nombre");

        txtNombreEmp.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel22.setText("Apellido");

        txtApellidoEmp.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel23.setText("Cedula");

        txtCedulaEmp.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel24.setText("Direccion");

        txtDirecEm.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel25.setText("Nivel Estudio");

        txtNivelEm.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel26.setText("Titulo");

        txtTituloEm.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jTEmpre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Empresario", "Nombre", "Apellido", "Cedula", "Direccion", "NivelEstudio", "Titulo"
            }
        ));
        jTEmpre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEmpreMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTEmpre);

        btnEmpresario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnEmpresario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresarioActionPerformed(evt);
            }
        });

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        btnEliminarEmpresario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarEmpresario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpresarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTituloEm, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNivelEm, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDirecEm, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCedulaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdEmpre, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnEmpresario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnEliminarEmpresario, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtIdEmpre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtNombreEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtApellidoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtCedulaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtDirecEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtNivelEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(txtTituloEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(btnEmpresario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarEmpresario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab7", jPanel23);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab8", jPanel24);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab9", jPanel25);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab10", jPanel26);

        jPanel27.setBackground(new java.awt.Color(204, 204, 204));

        txtIdFicha.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel41.setText("Id Ficha Individual");

        jLabel42.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel42.setText("Fecha");

        jTFicha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Ficha Individual", "Fecha"
            }
        ));
        jTFicha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFichaMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTFicha);

        btnGuardarFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarFichaActionPerformed(evt);
            }
        });

        jButton51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        btnEliminarFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFichaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnGuardarFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(btnEliminarFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(139, 139, 139)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(11, 11, 11)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(615, Short.MAX_VALUE))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtIdFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardarFicha, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jButton51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );

        jTabbedPane2.addTab("tab11", jPanel27);

        jPanel28.setBackground(new java.awt.Color(204, 204, 204));

        jLabel28.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel28.setText("Id Hoja Actividades");

        txtIdHoja.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel43.setText("Hora Inicio");

        txtHoraI.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel45.setText("Hora Final");

        txtHoraF.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel44.setText("Id Empresario");

        jComboBox7.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar-", "1234" }));

        jTHoja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Hoja Actividades", "Hora Inicio", "Hora Final", "Id Empresario"
            }
        ));
        jScrollPane11.setViewportView(jTHoja);

        btnGHoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGHoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGHojaActionPerformed(evt);
            }
        });

        btnHojaE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnHojaE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHojaEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdHoja, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel44)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel45)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtHoraF))
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel43)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnGHoja, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btnHojaE, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtIdHoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(txtHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(txtHoraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addComponent(btnGHoja, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(btnHojaE, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab12", jPanel28);

        jLabel46.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel46.setText("Id Grupo");

        jLabel47.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel47.setText("Aula");

        jLabel48.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel48.setText("Id Hoja Actividades");

        jComboBox13.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar-", "Item 2", "Item 3", "Item 4" }));

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Grupo", "Aula", "Id Hoja Actividades"
            }
        ));
        jScrollPane12.setViewportView(jTable12);

        jButton58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N

        jButton59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N

        jButton60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N

        jButton61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton58, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jButton60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton59, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jButton61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton58, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(jButton59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton61, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab13", jPanel29);

        jLabel49.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel49.setText("Id Asignatura");

        jComboBox14.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar-", "Item 2", "Item 3", "Item 4" }));

        jLabel50.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel50.setText("Id Empresario");

        jComboBox15.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar-", "Item 2", "Item 3", "Item 4" }));

        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Asignatura", "Id Empresario"
            }
        ));
        jScrollPane13.setViewportView(jTable13);

        jButton62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N

        jButton63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N

        jButton64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N

        jButton65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton62, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(jButton63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton65, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab14", jPanel30);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab15", jPanel31);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 960, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIrAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAsignaturaActionPerformed
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_btnIrAsignaturaActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton51ActionPerformed

    private void btnHojaEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHojaEActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = jTHoja.getSelectedRow();
        if (fila_seleccionada >= 0) {
            int decision = JOptionPane.showConfirmDialog(null, "Confirma que desea eliminar este registro de la hoja de actividades");
            if (decision == 0) {
                try {
                    this.CHoja.eliminarAsp(Conexion.obtener(), this.hoja.get(fila_seleccionada));
                    this.iniciarListaHoja();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro.");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro");
                }
            }
        }
         
    }//GEN-LAST:event_btnHojaEActionPerformed

    private void btnGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGAActionPerformed
        // TODO add your handling code here:
        if (this.validar()) {
            this.guardar();
            txtNombre.setText(null);
            txtApellido.setText(null);
            txtDireccion.setText(null);
            txtNivel.setText(null);
            txtTitulo.setText(null);
            jComboBox1.setSelectedItem("-Seleccionar-");
            jComboBox2.setSelectedItem("-Seleccionar-");
            this.iniciarLista();

        } else {
            JOptionPane.showMessageDialog(this, "Complete los campos.");
        }
    }//GEN-LAST:event_btnGAActionPerformed

    private void btnEAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEAActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = jT.getSelectedRow();
        if (fila_seleccionada >= 0) {
            int decision = JOptionPane.showConfirmDialog(null, "Confirma que desea eliminar este alumno");
            if (decision == 0) {
                try {
                    this.CA.eliminar(Conexion.obtener(), this.a.get(fila_seleccionada));
                    this.iniciarLista();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro.");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro");
                }
            }
        }
    }//GEN-LAST:event_btnEAActionPerformed

    private void btnMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAActionPerformed
        // TODO add your handling code here:
       if(this.validar()){
           this.actualizarAlum();
            txtNombre.setText(null);
            txtApellido.setText(null);
            txtDireccion.setText(null);
            txtNivel.setText(null);
            txtTitulo.setText(null);
            jComboBox1.setSelectedItem("-Seleccionar-");
            jComboBox2.setSelectedItem("-Seleccionar-");
           this.iniciarLista();
        }else{
            JOptionPane.showMessageDialog(this, "Verifique que los datos sean correctos.");
        }
    }//GEN-LAST:event_btnMAActionPerformed

    private void btnAsignaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignaActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdAsig.getText()) || !"".equals(txtNombreAs.getText())) {
            asi.setIdAsignatura(Integer.parseInt(txtIdAsig.getText()));
            asi.setNombre(txtNombreAs.getText());
            try {
                CAsigna.guardarAsig(Conexion.obtener(), this.asi);
                this.listaAsignaturas.removeAllItems();
                this.llenarEmpresarios(Conexion.obtener(), listaAsignaturas);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
            }
            txtIdAsig.setText(null);
            txtNombreAs.setText(null);
            this.iniciarListaAsignatura();
        } else {
            JOptionPane.showMessageDialog(this, "Complete los campos.");
        }
    }//GEN-LAST:event_btnAsignaActionPerformed

    private void btnEAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEAsigActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = jTAs.getSelectedRow();
        if (fila_seleccionada >= 0) {
            int decision = JOptionPane.showConfirmDialog(null, "Confirma que desea eliminar esta asignatura");
            if (decision == 0) {
                try {
                    this.CAsigna.eliminarAsig(Conexion.obtener(), this.asig.get(fila_seleccionada));
                    this.iniciarListaAsignatura();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro.");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro");
                }

            }
            txtIdAsig.setText(null);
            txtNombreAs.setText(null);
        }
    }//GEN-LAST:event_btnEAsigActionPerformed

    private void btnAcAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcAActionPerformed
        // TODO add your handling code here:
        this.actualizarAsig();
        txtIdAsig.setText(null);
        txtNombreAs.setText(null);
        this.iniciarListaAsignatura();
    }//GEN-LAST:event_btnAcAActionPerformed

    private void btnAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAspiranteActionPerformed
        if (!"".equals(txtAspirante.getText()) || !"".equals(txtNombreAspi.getText()) || !"".equals(listaAsignaturas.getSelectedItem())) {
            aspi.setIdAspirante(Integer.parseInt(txtAspirante.getText().toString()));
            aspi.setNombre(txtNombreAspi.getText());
            aspi.setIdAsignatura((Integer) listaAsignaturas.getSelectedItem());
            try {
                CAsp.guardarAsp(Conexion.obtener(), this.aspi);
                this.iniciarListaAspi();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
            }
            txtAspirante.setText(null);
            txtNombreAspi.setText(null);
            listaAsignaturas.setSelectedItem("-Seleccionar-");
        }
    }//GEN-LAST:event_btnAspiranteActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = jTAsp.getSelectedRow();
        if (fila_seleccionada >= 0) {
            int decision = JOptionPane.showConfirmDialog(null, "Confirma que desea eliminar este aspirante");
            if (decision == 0) {
                try {
                    this.CAsp.eliminarAsp(Conexion.obtener(), this.aps.get(fila_seleccionada));
                    this.iniciarListaAspi();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro.");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro");
                }
            }
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void btnEmpresarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresarioActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdEmpre.getText()) || !"".equals(txtNombreEmp.getText()) || !"".equals(txtApellidoEmp.getText()) || !"".equals(txtCedulaEmp.getText()) || !"".equals(txtDirecEm.getText()) || !"".equals(txtNivelEm.getText()) || !"".equals(txtTituloEm.getText())) {
            empre.setIdEmpresario(Integer.parseInt(txtIdEmpre.getText()));
            empre.setNombre(txtNombreEmp.getText());
            empre.setApellido(txtApellidoEmp.getText());
            empre.setCedula(Integer.parseInt(txtCedulaEmp.getText()));
            empre.setDireccion(txtDirecEm.getText());
            empre.setNivel_Estudio(txtNivelEm.getText());
            empre.setTitulo(txtTituloEm.getText());

            try {
                CEmpr.guardar(Conexion.obtener(), this.empre);
                this.jComboBox7.removeAllItems();
                this.llenarEmpresarios(Conexion.obtener(), jComboBox7);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
            }
            this.iniciarListaEmp();
            txtIdEmpre.setText(null);
            txtNombreEmp.setText(null);
            txtApellidoEmp.setText(null);
            txtCedulaEmp.setText(null);
            txtDirecEm.setText(null);
            txtNivelEm.setText(null);
            txtTituloEm.setText(null);
        } else {
            JOptionPane.showMessageDialog(this, "Complete los campos.");
        }

    }//GEN-LAST:event_btnEmpresarioActionPerformed

    private void btnEliminarEmpresarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpresarioActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = jTEmpre.getSelectedRow();
        if (fila_seleccionada >= 0) {
            int decision = JOptionPane.showConfirmDialog(null, "Confirma que desea eliminar este empresario");
            if (decision == 0) {
                try {
                    this.CEmpr.eliminar(Conexion.obtener(), this.emp.get(fila_seleccionada));
                    this.iniciarListaEmp();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro.");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro");
                }
                txtIdEmpre.setText(null);
                txtNombreEmp.setText(null);
                txtApellidoEmp.setText(null);
                txtCedulaEmp.setText(null);
                txtDirecEm.setText(null);
                txtNivelEm.setText(null);
                txtTituloEm.setText(null);
            }
        }

    }//GEN-LAST:event_btnEliminarEmpresarioActionPerformed

    private void btnGuardarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarFichaActionPerformed
        // TODO add your handling code here:
        if (this.validarFicha()) {
            this.guardarFicha();
            this.jComboBox2.removeAllItems();
            try {
                this.llenarFicha(Conexion.obtener(), jComboBox2);
            } catch (SQLException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtIdFicha.setText(null);
            jDateChooser2.setCalendar(null);
            this.iniciarListaFicha();
        } else {
            JOptionPane.showMessageDialog(this, "Complete los campos");
        }
    }//GEN-LAST:event_btnGuardarFichaActionPerformed

    private void btnEliminarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFichaActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = jTFicha.getSelectedRow();
        if (fila_seleccionada >= 0) {
            int decision = JOptionPane.showConfirmDialog(null, "Confirma que desea eliminar esta ficha?");
            if (decision == 0) {
                try {
                    this.CFic.eliminar(Conexion.obtener(), this.fic.get(fila_seleccionada));
                    this.iniciarListaFicha();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro.");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Error, no se ha eliminado el registro.");
                }
            }

        }
    }//GEN-LAST:event_btnEliminarFichaActionPerformed

    private void btnIrAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAlumnoActionPerformed
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_btnIrAlumnoActionPerformed

    private void btnIrAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAspiranteActionPerformed
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_btnIrAspiranteActionPerformed

    private void btnIrEmpresarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrEmpresarioActionPerformed
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(5);
    }//GEN-LAST:event_btnIrEmpresarioActionPerformed

    private void btnIrFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrFichaActionPerformed
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(9);
    }//GEN-LAST:event_btnIrFichaActionPerformed

    private void btnIrHojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrHojaActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(10);
    }//GEN-LAST:event_btnIrHojaActionPerformed

    private void jTAsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAsMouseClicked
        // TODO add your handling code here:
        int fila_seleccionada = jTAs.getSelectedRow();
        txtIdAsig.setText(jTAs.getValueAt(fila_seleccionada, 0).toString());
        txtNombreAs.setText(jTAs.getValueAt(fila_seleccionada, 1).toString());

        id_asig = Integer.parseInt(jTAs.getValueAt(fila_seleccionada, 0).toString());

    }//GEN-LAST:event_jTAsMouseClicked

    private void jTAspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAspMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAspMouseClicked

    private void jTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMouseClicked
        // TODO add your handling code here:
       int fila_seleccionada0  = jT.getSelectedRow();
        
        txtNombre.setText(jT.getValueAt(fila_seleccionada0, 1).toString());
        txtApellido.setText(jT.getValueAt(fila_seleccionada0, 2).toString());
        txtDireccion.setText(jT.getValueAt(fila_seleccionada0, 3).toString());
        txtNivel.setText(jT.getValueAt(fila_seleccionada0, 4).toString());
        txtTitulo.setText(jT.getValueAt(fila_seleccionada0, 5).toString());
        jComboBox1.setSelectedItem(jT.getValueAt(fila_seleccionada0, 6).toString());
        jComboBox2.setSelectedItem(jT.getValueAt(fila_seleccionada0, 7).toString());
        
        this.id_Alumno=Integer.parseInt(jT.getValueAt(fila_seleccionada0, 0).toString());
        
    }//GEN-LAST:event_jTMouseClicked

    private void jTFichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFichaMouseClicked
        // TODO add your handling code here:
        int fila_seleccionada15 = jTFicha.getSelectedRow();
        txtIdFicha.setText(jTFicha.getValueAt(fila_seleccionada15, 0).toString());
        
    }//GEN-LAST:event_jTFichaMouseClicked

    private void jTEmpreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEmpreMouseClicked
        // TODO add your handling code here:
        int fila_seleccionada4 = jTEmpre.getSelectedRow();
        txtIdEmpre.setText(jTEmpre.getValueAt(fila_seleccionada4, 0).toString());
        txtNombreEmp.setText(jTEmpre.getValueAt(fila_seleccionada4, 1).toString());
        txtApellidoEmp.setText(jTEmpre.getValueAt(fila_seleccionada4, 2).toString());
        txtCedulaEmp.setText(jTEmpre.getValueAt(fila_seleccionada4, 3).toString());
        txtDirecEm.setText(jTEmpre.getValueAt(fila_seleccionada4, 4).toString());
        txtNivelEm.setText(jTEmpre.getValueAt(fila_seleccionada4, 5).toString());
        txtTituloEm.setText(jTEmpre.getValueAt(fila_seleccionada4, 6).toString());
        
        id_emp = Integer.parseInt(jTEmpre.getValueAt(fila_seleccionada4, 0).toString());
        
    }//GEN-LAST:event_jTEmpreMouseClicked

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
        
        this.actualizarEmp();
        txtIdEmpre.setText(null);
        txtNombreEmp.setText(null);
        txtApellidoEmp.setText(null);
        txtCedulaEmp.setText(null);
        txtDirecEm.setText(null);
        txtNivelEm.setText(null);
        txtTituloEm.setText(null);
        this.iniciarListaEmp();
    }//GEN-LAST:event_jButton37ActionPerformed

    private void btnGHojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGHojaActionPerformed
        // TODO add your handling code here:
        if(!"".equals(txtIdHoja.getText()) || !"".equals(txtHoraI.getText()) || !"".equals(txtHoraF.getText()) || !"".equals(jComboBox7.getSelectedItem())){
            hojaA.setIdHoja_Actividades(Integer.parseInt(txtIdHoja.getText()));
            hojaA.setHora_Inicio(txtHoraI.getText());
            hojaA.setHora_Final(txtHoraF.getText());
            hojaA.setIdEmpresario(Integer.parseInt(jComboBox7.getSelectedItem().toString()));
            try{
                CHoja.guardarHoja(Conexion.obtener(), this.hojaA);
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
            }
            this.iniciarListaHoja();
            txtIdHoja.setText(null);
            txtHoraI.setText(null);
            txtHoraF.setText(null);
            jComboBox7.setSelectedItem("-Seleccionar-");
        }
    }//GEN-LAST:event_btnGHojaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
           this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtAspiranteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAspiranteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAspiranteKeyPressed

    private void btnBuscarAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAspiranteActionPerformed
        try {
            // TODO add your handling code here:
            this.BuscarAspirante(Conexion.obtener());
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarAspiranteActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtAspirante.setText(null);
        txtNombreAspi.setText(null);
        listaAsignaturas.setSelectedItem("-Seleccionar-");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public void BuscarAspirante(Connection conexion) throws SQLException {
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM aspirante WHERE idAspirante =?");
            consulta.setString(1, txtAspirante.getText());
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next()){
                txtNombreAspi.setText(resultado.getString("Nombre"));
                listaAsignaturas.setSelectedItem(resultado.getInt("idAsignatura"));
            }else{
                JOptionPane.showMessageDialog(this, "No existe aspirante.");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void actualizarAlum(){
        alumnos alm = new alumnos();
       
        String Nombre = txtNombre.getText();
        String Apellido = txtApellido.getText();
        String Direccion = txtDireccion.getText();
        String Nivel_Estudio = txtNivel.getText();
        String Titulo = txtTitulo.getText();
        Integer idGrupo = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        Integer idFicha_Individual = Integer.parseInt(jComboBox2.getSelectedItem().toString());
        
        alm.setNombre(Nombre);
        alm.setApellido(Apellido);
       
        alm.setDireccion(Direccion);
        alm.setNivel_Estudio(Nivel_Estudio);
        alm.setTitulo(Titulo);
        alm.setIdGrupo(idGrupo);
        alm.setIdFicha_Individual(idFicha_Individual);
        //this.CA.recuperarCombobox1(Conexion.obtener(), id);
        try{
            this.CA.actualizar(Conexion.obtener(), alm , id_Alumno);
             
            jT.setVisible(true);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se ha podido actualizar el registro.");
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error, no se ha podido actualizar el registro.");
        }
   }
    
    private void actualizarEmp() {
        empresario empre = new empresario();
        Integer idEmpresario = Integer.parseInt(txtIdEmpre.getText());
        String Nombre = txtNombreEmp.getText();
        String Apellido = txtApellidoEmp.getText();
        Integer Cedula = Integer.parseInt(txtCedulaEmp.getText());
        String Direccion = txtDirecEm.getText();
        String Nivel_Estudio = txtNivelEm.getText();
        String Titulo = txtTituloEm.getText();
        
        empre.setIdEmpresario(idEmpresario);
        
        empre.setNombre(Nombre);
        empre.setApellido(Apellido);
        empre.setCedula(Cedula);
        empre.setDireccion(Direccion);
        empre.setNivel_Estudio(Nivel_Estudio);
        empre.setTitulo(Titulo);
        
        try{
            this.CEmpr.actualizarEmp(Conexion.obtener(), empre, id_emp);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se ha podido actualizar el registro.");
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error, no se ha podido actualizar el registro.");
        }

    }
    
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        try {
            Conexion.cerrar();
            System.out.println("Conexión cerrada.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private boolean validar() {
        boolean val = false;
        String Nombre = txtNombre.getText();
        String Apellido = txtApellido.getText();
        String Direccion = txtDireccion.getText();
        String Nivel_Estudio = txtNivel.getText();
        String Titulo = txtTitulo.getText();
        Integer idGrupo;
        Integer idFicha_Individual;
        if (!Nombre.trim().equals("") && !Apellido.trim().equals("") && !Direccion.trim().equals("") && !Nivel_Estudio.trim().equals("") && !Titulo.trim().equals("")) {
            try {
                idGrupo = Integer.parseInt(jComboBox1.getSelectedItem().toString());
                idFicha_Individual = Integer.parseInt(jComboBox2.getSelectedItem().toString());
                val = true;
            } catch (Exception ex) {
                val = false;
            }
        } else {
            val = false;
        }
        return val;
    }

    private void guardar() {
        String Nombre = txtNombre.getText();
        String Apellido = txtApellido.getText();
        String Direccion = txtDireccion.getText();
        String Nivel_Estudio = txtNivel.getText();
        String Titulo = txtTitulo.getText();
        Integer idGrupo = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        Integer idFicha_Individual = Integer.parseInt(jComboBox2.getSelectedItem().toString());
        this.al.setNombre(Nombre);
        this.al.setApellido(Apellido);
        this.al.setDireccion(Direccion);
        this.al.setNivel_Estudio(Nivel_Estudio);
        this.al.setTitulo(Titulo);
        this.al.setIdGrupo(idGrupo);
        this.al.setIdFicha_Individual(idFicha_Individual);
        try {
            this.CA.guardar(Conexion.obtener(), this.al);
            jT.setVisible(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
        }
    }

    private boolean validarFicha() {
        boolean valF = false;
        Integer idFicha_individual;
        Date Fecha;

        try {
            idFicha_individual = Integer.parseInt(txtIdFicha.getText());
            Fecha = jDateChooser2.getDate();

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            String fecha_formateada = formato.format(Fecha);
            java.sql.Date fecha_in = java.sql.Date.valueOf(fecha_formateada);

            valF = true;
        } catch (Exception ex) {
            valF = false;
            valF = false;
        }

        return valF;
    }

    private void guardarFicha() {
        Integer idFicha_individual = Integer.valueOf(txtIdFicha.getText());
        Date Fecha = jDateChooser2.getDate();

        Date Fechas = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha_formateada = formato.format(Fecha);
        java.sql.Date fecha_in = java.sql.Date.valueOf(fecha_formateada);

        this.ficha.setIdFicha_individual(idFicha_individual);
        this.ficha.setFecha(fecha_in);

        try {
            this.CFic.guardar(Conexion.obtener(), this.ficha);
            jTFicha.setVisible(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error, no se ha podido guardar el registro");
        }

    }
    
   


 
    
     public void llenar_asignatura(Connection conexion, JComboBox asignatura) throws SQLException {
        java.util.List<aspirante> ap = new ArrayList<>();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT idFicha_individual FROM ficha_individual");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                int x = resultado.getInt("idFicha_individual");
                asignatura.addItem(x);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void llenarFicha(Connection conexion, JComboBox fic) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT idFicha_individual FROM ficha_individual");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                int x = resultado.getInt("idFicha_individual");
                fic.addItem(x);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public void llenarEmpresarios(Connection conexion, JComboBox empres) throws SQLException {
        try{
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT idEmpresario FROM empresario");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                int x = resultado.getInt("idEmpresario");
                empres.addItem(x);
            }
        }catch (SQLException ex) {
            throw new SQLException(ex);
        }
        
    }

    private void actualizarAsig() {
        asignatura asignatura = new asignatura();
        Integer idAsignatura = Integer.parseInt(txtIdAsig.getText());
        String Nombre = txtNombreAs.getText();

        asignatura.setIdAsignatura(idAsignatura);

        asignatura.setNombre(Nombre);

        try {
            this.CAsigna.actualizarAsi(Conexion.obtener(), asignatura, id_asig);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se ha podido actualizar el registro.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error, no se ha podido actualizar el registro.");
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Sistema().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcA;
    private javax.swing.JButton btnAsigna;
    private javax.swing.JButton btnAspirante;
    private javax.swing.JButton btnBuscarAspirante;
    private javax.swing.JButton btnEA;
    private javax.swing.JButton btnEAsig;
    private javax.swing.JButton btnEliminarEmpresario;
    private javax.swing.JButton btnEliminarFicha;
    private javax.swing.JButton btnEmpresario;
    private javax.swing.JButton btnGA;
    private javax.swing.JButton btnGHoja;
    private javax.swing.JButton btnGuardarFicha;
    private javax.swing.JButton btnHojaE;
    private javax.swing.JButton btnIrAlumno;
    private javax.swing.JButton btnIrAsignatura;
    private javax.swing.JButton btnIrAspirante;
    private javax.swing.JButton btnIrEmpresario;
    private javax.swing.JButton btnIrFicha;
    private javax.swing.JButton btnIrHoja;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    public javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox7;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    public javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jT;
    private javax.swing.JTable jTAs;
    private javax.swing.JTable jTAsp;
    private javax.swing.JTable jTEmpre;
    private javax.swing.JTable jTFicha;
    private javax.swing.JTable jTHoja;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JComboBox<String> listaAsignaturas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoEmp;
    private javax.swing.JTextField txtAspirante;
    private javax.swing.JTextField txtCedulaEmp;
    private javax.swing.JTextField txtDirecEm;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtHoraF;
    private javax.swing.JTextField txtHoraI;
    private javax.swing.JTextField txtIdAsig;
    private javax.swing.JTextField txtIdEmpre;
    private javax.swing.JTextField txtIdFicha;
    private javax.swing.JTextField txtIdHoja;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtNivelEm;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreAs;
    private javax.swing.JTextField txtNombreAspi;
    private javax.swing.JTextField txtNombreEmp;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTituloEm;
    // End of variables declaration//GEN-END:variables
}
