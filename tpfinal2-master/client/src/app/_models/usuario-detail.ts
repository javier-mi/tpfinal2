import { UsuarioAuthority } from './usuario-authority';

export class UsuarioDetail {
    password: string;
    usuarioname: string;
    usuarioDetails: [UsuarioAuthority];
    accountNonExpired: boolean;
    accountNonLocked: boolean;
    credentialsNonExpired: boolean;
    enabled: boolean;
}
