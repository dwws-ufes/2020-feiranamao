import { UsuarioModel } from "./usuario.view-model";

export interface LojaModel {
  id: string;
  nome: string;
  logo?: string;
  dono: UsuarioModel;
}
