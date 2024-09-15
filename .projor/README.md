# ProJor Spring Boot CRUD Template

This is a [ProJor](https://projor.io) template, that generates a _Spring Boot application_, which implements _CRUD operations_ for a given entity. The app serves an _HTTP API_, that can be used to create, read, update and delete entities of the supported types.

## Using

* You should first install [ProJor](https://projor.io) to get started with this template.
* After that, open up the [`.entities`](.entities) file and start defining the entities you want your app to support:

```
entity Author {
    name: String
}
entity Article {
    @Join Author author
    title: String
    summary: String
    body: String
}
```

* Then, run the following command in the terminal:

```bash
projor generate
```

* After that, you can build and start the application by running:

_Linux_

```bash
./gradlew bootRun
```

_Windows_

```bash
gradlew bootRun
```

* After that, you can access the API at `http://localhost:8080`. See the [README](../README.md) for a reference to the API.
* Whenever you want to _modify how the code is generataed_, you should edit the templates in [template](template/), and run `projor generate` again.

## How it works

* This template uses the [`entities.plang.js`](language/entities.plang.js) script to define a _[domain specific language](https://docs.projor.io/overview/languages)_ for defining entities.
* We have defined the [Entity schema](schema/Entity.pschema.yaml), and the [`.entities`](.entities) file is parsed by the language into this schema. This creates a [data collection](https://docs.projor.io/overview/data-collections) of entities, with ID `entities`.
* We created a couple of [templates](template/) to generate the _JPA entity classes_, _repository interfaces_, _CRUD services_, _controllers_, _build scripts_ and all other necessary _boilerplate_ code.

## License

The template is licensed under MIT.

[ProJor](https://projor.io) is licensed under either the [ProJor Free License](https://license.projor.io) or the [ProJor Commercial License](https://license.projor.io).