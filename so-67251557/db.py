import csv

import sqlite3

open("shows.db", "w").close()
con = sqlite3.connect('shows.db')
db = con.cursor()


db.execute("CREATE TABLE shows (id INTEGER, title TEXT, PRIMARY KEY(id))")
db.execute("CREATE TABLE genres (show_id INTEGER, genre TEXT, FOREIGN KEY(show_id) REFERENCES shows(id))")


shows = ["FRIENS", "Game of Trhones", "Want", "Scooby Doo"]
genres = ["Comedy", "Fantasy", "Action", "Cartoon"]


for ind, show in enumerate(shows):
    db.execute("INSERT INTO shows (title) VALUES(?)", (show,))
    id_ = con.execute(
        "SELECT id FROM shows WHERE title = :show ORDER BY id DESC LIMIT 1",
        {
            "show": show
        },
    ).fetchone()


    print(id_, show, genres[ind])
    db.execute(
        "INSERT INTO genres (show_id, genre) VALUES (?, ?)",
        (id_[0], genres[ind], )
    )

con.commit()

con.close()