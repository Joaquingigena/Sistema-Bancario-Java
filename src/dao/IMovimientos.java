package dao;

import java.util.List;

import entidades.Movimientos;

public interface IMovimientos {

	public List<Movimientos> obtenerMovimientosPorUsuario(int idUsuario);
}
