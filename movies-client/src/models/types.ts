export type Movie = {
    id: object,
    imdbId: string,
    title: string,
    releaseDate: string,
    trailerLink: string,
    poster: string,
    genres: string[],
    backdrops: string[]
}

export type Review = {
    id?: string,
    body: string,
}
