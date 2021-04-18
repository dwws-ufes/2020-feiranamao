<?php

$files = [
	'Categoria',
	'ItemPedido',
	'Loja',
	'Pedido',
	'Produto',
	'Usuario',
	'CategoriasRepository',
	'ItemPedidoRepository',
	'LojasRepository',
	'PedidosRepository',
	'ProdutosRepository',
	'UsuarioRepository',
	'PedidoRecurso',
	'ProdutoRecurso'
];

for ($x = 0; $x <= count($files); $x++) {
	$file = $files[$x];
	
	$percent = -1;
	
	similar_text(file_get_contents($file.'_old.java'), file_get_contents($file.'_new.java'), $percent);
	
	if($percent > 20)
	{
		echo $file.' '.round($percent,2)."%<br/><br/>";
	}
}