export interface IClient {
  id?: number;
  name?: string | null;
  email?: string | null;
  phone?: string | null;
  jobTitle?: string | null;
}

export class Client implements IClient {
  constructor(
    public id?: number,
    public name?: string | null,
    public email?: string | null,
    public phone?: string | null,
    public jobTitle?: string | null
  ) {}
}

export function getClientIdentifier(client: IClient): number | undefined {
  return client.id;
}
