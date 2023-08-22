export interface Weather {

    city: string
    temperature: string
    conditions: Conditions[]
    weatherTimeStamp: BigInt
    sunriseTimeStamp: bigint
    sunsetTimeStamp: BigInt

}

export interface Conditions {

    description: string,
    icon: string
    
}