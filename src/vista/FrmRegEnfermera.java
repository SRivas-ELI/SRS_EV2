package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Categoria;
import entity.Enfermera;
import model.CategoriaModel;
import model.EnfermeraModel;
import util.ValidateUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmRegEnfermera extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtDni;
	private JTextField txtFNaci;
	private JTextField txtFContra;
	private JComboBox<String> cbCategoria;
	private JButton btRegistrar;
	private JButton btLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegEnfermera frame = new FrmRegEnfermera();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegEnfermera() {
		setTitle("Registro Enfermera");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro Enfermera");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(107, 11, 249, 40);
		contentPane.add(lblNewLabel);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(92, 61, 143, 20);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setBounds(10, 64, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellidos:");
		lblNewLabel_1_1.setBounds(10, 95, 70, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(92, 92, 143, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(344, 92, 110, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(304, 61, 150, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(344, 123, 85, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono:");
		lblNewLabel_2.setBounds(259, 95, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(259, 64, 60, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DNI: ");
		lblNewLabel_4.setBounds(259, 126, 60, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Categoria:");
		lblNewLabel_5.setBounds(10, 192, 70, 14);
		contentPane.add(lblNewLabel_5);
		
		cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(92, 188, 227, 22);
		contentPane.add(cbCategoria);
		
		txtFNaci = new JTextField();
		txtFNaci.setBounds(150, 123, 85, 20);
		contentPane.add(txtFNaci);
		txtFNaci.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_6.setBounds(10, 126, 135, 14);
		contentPane.add(lblNewLabel_6);
		
		txtFContra = new JTextField();
		txtFContra.setBounds(150, 154, 85, 20);
		contentPane.add(txtFContra);
		txtFContra.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de Contratacion:");
		lblNewLabel_7.setBounds(10, 157, 135, 14);
		contentPane.add(lblNewLabel_7);
		
		btRegistrar = new JButton("Registrar");
		btRegistrar.addActionListener(this);
		btRegistrar.setBounds(364, 153, 90, 23);
		contentPane.add(btRegistrar);
		
		btLimpiar = new JButton("Limpiar");
		btLimpiar.addActionListener(this);
		btLimpiar.setBounds(364, 188, 90, 23);
		contentPane.add(btLimpiar);
		
		cargarCategoria();

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btLimpiar) {
			do_btLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btRegistrar) {
			do_btRegistrar_actionPerformed(e);
		}
	}
	protected void do_btRegistrar_actionPerformed(ActionEvent e) {
		String nombres = txtNombres.getText().trim();
		String apellidos = txtApellidos.getText().trim();
		String email = txtEmail.getText().trim();
		String telefono = txtTelefono.getText().trim();
		String dni = txtDni.getText().trim();
		String fechaNacimiento = txtFNaci.getText().trim();
		String fechaContratacion = txtFContra.getText().trim();
		String cateSele = cbCategoria.getSelectedItem().toString();
		String aviso = "";
		

		if (!nombres.matches(ValidateUtil.TEXTO_30)) {
			aviso += "El nombre es inválido. Debe contener solo letras y espacios, y tener entre 1 y 30 caracteres.\n";
		}
		if (!apellidos.matches(ValidateUtil.TEXTO_30)) {
			aviso += "El apellido es inválido. Debe contener solo letras y espacios, y tener entre 1 y 30 caracteres.\n";
		}
		if (!email.matches(ValidateUtil.EMAIL)) {
			aviso += "El email es inválido. Debe tener un formato válido.\n";
		}
		if (!telefono.matches(ValidateUtil.TELEFONO)) {
			aviso += "El telefono es inválido. Debe tener exactamente 9 digitos.\n";
		}
		if (!dni.matches(ValidateUtil.DNI)) {
			aviso += "El DNI es inválido. Debe tener exactamente 8 digitos.\n";
		}
		EnfermeraModel checker = new EnfermeraModel();
		String extra = checker.dniChecker(dni);
		if (extra != "") {
			aviso += "El DNI es ya existe.\n";
		}
		if (!fechaNacimiento.matches(ValidateUtil.DATE_YYYY_MM_DD)) {
			aviso += "La fecha de nacimiento es inválida. Debe tener el formato YYYY-MM-DD.\n";
		}
		if (!fechaContratacion.matches(ValidateUtil.DATE_YYYY_MM_DD)) {
			aviso += "La fecha de contratacion es inválida. Debe tener el formato YYYY-MM-DD.\n";
		}
		if (cbCategoria.getSelectedIndex() == 0) {
			aviso += "Debe seleccionar una categoria.";
		}
		if (aviso != "") {
			JOptionPane.showMessageDialog(this, aviso);
			return;
		}
		
		Categoria objCategoria = new Categoria();
		objCategoria.setIdCategoria(Integer.parseInt(cateSele.split(" - ")[0]));
		
		Enfermera objEnfermera = new Enfermera();
		objEnfermera.setNombres(nombres);
		objEnfermera.setApellidos(apellidos);	
		objEnfermera.setEmail(email);
		objEnfermera.setTelefono(telefono);
		objEnfermera.setDni(Integer.parseInt(dni));
		objEnfermera.setFechaNacimiento(LocalDate.parse(fechaNacimiento));
		objEnfermera.setFechaContratacion(LocalDate.parse(fechaContratacion));
		objEnfermera.setCategoria(objCategoria);
		
		EnfermeraModel objEnfermeraModel = new EnfermeraModel();
		int insertados = objEnfermeraModel.insertaEnfermera(objEnfermera);
		
		if (insertados > 0) {
	           JOptionPane.showMessageDialog(this, "Enfermera registrada correctamente");
		}
		
	}
	protected void do_btLimpiar_actionPerformed(ActionEvent e) {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		txtDni.setText("");
		txtFNaci.setText("");
		txtFContra.setText("");
		cbCategoria.setSelectedIndex(0);
		
	}
	public void cargarCategoria() {
		CategoriaModel model = new CategoriaModel();
		List<Categoria> tipos = model.listCategoria();
		cbCategoria.addItem("[ Seleccione un tipo] ");
		for (Categoria tipo : tipos) {
			cbCategoria.addItem(tipo.getIdCategoria() + " - " + tipo.getDescripcion());
		}
		
	}
}
