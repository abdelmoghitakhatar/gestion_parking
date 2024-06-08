export interface RegisterModel {
  firstName: string
  lastName: string
  password: string
  email: string
  phone: string
  address: string
}

export interface UserResponse {
  userName: string
  firstName: string
  lastName: string
  email: string
  reservations: any
  vehicles: any
}
