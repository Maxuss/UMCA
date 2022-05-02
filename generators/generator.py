import typer

import block_gen
import material_gen


def generator(args: str):
    """
    Generates data classes
    :param args: Arguments for the generator, supports 'm' for material class, and 'b' for block type class
    """
    if "m" in args:
        material_gen.gen_material_class()

    if "b" in args:
        block_gen.gen_blocktype_class()


if __name__ == "__main__":
    typer.run(generator)
