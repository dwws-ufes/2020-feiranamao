export class OauthAccountViewModel {
  access_token: string;
  token_type: string;
  refresh_token: string;
  scope: string;

  constructor(u: any) {
      this.access_token = u.access_token != undefined ? u.access_token : null;
      this.token_type = u.token_type != null ? u.token_type : null;
      this.refresh_token = u.refresh_token != null ? u.refresh_token : null;
      this.scope = u.scope != null ? u.scope : null;
    }
}
