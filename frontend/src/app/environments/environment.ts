
/* Create URL Default APIs */
const URL_DEFAULT_API = '177.71.44.72:8380';
// const URL_DEFAULT_API = '192.168.1.198:8080';
// const URL_DEFAULT_API = 'f38a1daf.ngrok.io';
// const URL_DEFAULT_API = '2f458bf1.ngrok.io';

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


