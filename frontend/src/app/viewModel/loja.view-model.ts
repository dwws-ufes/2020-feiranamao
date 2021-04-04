import { UsuarioModel } from "./usuario.view-model";

export interface LojaModel {
  id: string | undefined;
  nome: string | undefined;
  logo: string | undefined;
  dono: UsuarioModel | undefined;
}
