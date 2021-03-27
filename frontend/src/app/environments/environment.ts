
/* Create URL Default APIs */
const URL_DEFAULT_API = '127.0.0.1:4200';
const PROTOCOL_HTTPS = false;
const HTTP_API = PROTOCOL_HTTPS ? 'https://' : 'http://';
const URL_API = HTTP_API + URL_DEFAULT_API;

/*Services Endpoint control names */
const LOGIN_API = '/api/login';


export const environment = {
  production: false,
  envName: 'dev',
  version: '0.0.1',

  LOGIN_ENDPOINT: LOGIN_API,
  URL_API: URL_API
};


