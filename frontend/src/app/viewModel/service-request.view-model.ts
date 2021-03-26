export class ServiceRequestViewModel {
    serviceName: string;
    requestBody: [];


    constructor(data: any) {
        this.serviceName = data.serviceName != null ? data.serviceName : null;
        this.requestBody = data.responseBody != null ? data.responseBody : null;
    }
}


