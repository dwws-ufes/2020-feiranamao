export class UserAccountViewModel {
    email: string;
    senha: string;
    constructor(u: any) {
        this.email = u.name != null ? u.name : null;
        this.senha = u.password != null ? u.password : null;
    }
}
