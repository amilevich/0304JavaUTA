import { Specialties } from "./specialties";

export class Doctor {
    doctorId: number;
    firstName: string;
    lastName: string;
    userName: string;
    passWord: string;
    ssN: number;
    phone: number;
    email: string;
    medicalId: string;
    gender: string;
    affiliation: string;
    street: string;
    city: string;
    state: string;
    zipcode: string;
    street2: string;
    city2: string;
    state2: string;
    zipcode2: string;
    experience: number;
    certification: string;
    education: string;
    profilepic: string;
    selectedSpecialty: string;
    specialty: string;
    specialties: Specialties[];
    conditions: string[];
    languages: string[];
    procedures: string[];
    insurances: string[];
    appointments: string[];
}