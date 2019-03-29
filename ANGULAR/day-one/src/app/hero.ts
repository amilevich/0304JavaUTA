export class Hero {
    id: number;
    name: string;
    imageUrl: string;
    power: number;

    constructor(id: number = 0, name: string = '', imageUrl: string = '', power: number = 0) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.power = power;
    }
}
