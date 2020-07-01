package edu.cientifica.papeleta.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import edu.cientifica.papeleta.model.Usuario;
import edu.cientifica.papeleta.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	protected final Log LOG = LogFactory.getLog(this.getClass());
	private List<Usuario> listaUsuarios;

	public UsuarioServiceImpl() {
		super();
		listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(new Usuario("Juan", "clave"));
		listaUsuarios.add(new Usuario("Pedro", "clave"));
		listaUsuarios.add(new Usuario("Anita", "clave"));
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return listaUsuarios;
	}

	@Override
	public Usuario buscarUsuario(String username) {
		LOG.info("buscado usuario"+username);
		for (Usuario usuario : listaUsuarios) {
			if (usuario.getUsername().equals(username)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public boolean validarUsuario(Usuario usuario) {
		for (Usuario user : listaUsuarios) {
			if (usuario.getUsername().equals(user.getUsername())) {
				if (usuario.getPassword().equals(user.getPassword())) {
					return true;
				} 
			}
		}		
		return false;
	}
}
