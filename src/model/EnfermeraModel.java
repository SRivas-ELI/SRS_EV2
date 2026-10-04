package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.Enfermera;
import util.MySqlCon;

public class EnfermeraModel {
	public int insertaEnfermera(Enfermera enfermera) {
		int insertados = 0;
			
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = MySqlCon.getConexion();
			String sql = "INSERT INTO enfermera(nombres, apellidos, fechaNacimiento, fechaContratacion, telefono, email, dni, categoria) VALUES(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, enfermera.getNombres());
			ps.setString(2, enfermera.getApellidos());
			ps.setDate(3, java.sql.Date.valueOf(enfermera.getFechaNacimiento()));
			ps.setDate(4, java.sql.Date.valueOf(enfermera.getFechaContratacion()));
			ps.setString(5, enfermera.getTelefono());
			ps.setNString(6, enfermera.getEmail());
			ps.setInt(7, enfermera.getDni());
			ps.setInt(8, enfermera.getCategoria().getIdCategoria());

			insertados = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al insertar enfermera: " + e.getMessage());
		} finally {
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion: " + e.getMessage());
			}
		}
		
		return insertados;
	}
	
	public String dniChecker(String dni) {
		String dniAviso = "";
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = MySqlCon.getConexion();
			String sql = "SELECT * FROM enfermera WHERE dni = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dni);
			
			if (ps.executeQuery().next()) {
				dniAviso = "El DNI ya se encuentra registrado.";
			}
		} catch (Exception e) {
			System.out.println("Error al verificar el DNI: " + e.getMessage());
		} finally {
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar la conexion: " + e.getMessage());
			}
		}
		
		return dniAviso;

	}
}