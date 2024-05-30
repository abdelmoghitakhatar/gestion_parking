export class RegisterModel {
  public firstName!: string
  public lastName!: string
  public password!: string
  public email!: string
  public phone!: string
  public address!: string
}

export class UserResponse {
  public userName!: string
  public firstName!: string
  public lastName!: string
  public email!: string
  public reservations!: any
  public vehicles!: any
}
