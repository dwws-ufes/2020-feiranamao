import { FuseUtils } from '@fuse/utils';

export class AuthResponse
{
    access_token: string;
    token_type: string;
    refresh_token: string;
    expires_in: string;
    scope: string;

    /**
     * Constructor
     *
     * @param authResponse
     */
    constructor(authResponse)
    {
        {
         
            this.access_token = authResponse.access_token || '';
            this.token_type = authResponse.token_type || '';
            this.refresh_token = authResponse.refresh_token || '';
            this.expires_in = authResponse.expires_in || '';
            this.scope = authResponse.scope || '';
        }
    }
}
