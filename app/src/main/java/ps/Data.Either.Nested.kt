@file:Suppress("UNCHECKED_CAST")
package PS.Data.Either.Nested
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val in9 = { v : Any ->
     PS.Data.Either.Module.Right
       .app(PS.Data.Either.Module.Right
              .app(PS.Data.Either.Module.Right
                     .app(PS.Data.Either.Module.Right
                            .app(PS.Data.Either.Module.Right
                                   .app(PS.Data.Either.Module.Right
                                          .app(PS.Data.Either.Module.Right
                                                 .app(
                  PS.Data.Either.Module.Right
                    .app(PS.Data.Either.Module.Left.app(v)))))))))
  };
  @JvmField
  val in8 = { v : Any ->
     PS.Data.Either.Module.Right
       .app(PS.Data.Either.Module.Right
              .app(PS.Data.Either.Module.Right
                     .app(PS.Data.Either.Module.Right
                            .app(PS.Data.Either.Module.Right
                                   .app(PS.Data.Either.Module.Right
                                          .app(PS.Data.Either.Module.Right
                                                 .app(PS.Data.Either.Module.Left
                                                        .app(v))))))))
  };
  @JvmField
  val in7 = { v : Any ->
     PS.Data.Either.Module.Right
       .app(PS.Data.Either.Module.Right
              .app(PS.Data.Either.Module.Right
                     .app(PS.Data.Either.Module.Right
                            .app(PS.Data.Either.Module.Right
                                   .app(PS.Data.Either.Module.Right
                                          .app(PS.Data.Either.Module.Left.app(v)
              ))))))
  };
  @JvmField
  val in6 = { v : Any ->
     PS.Data.Either.Module.Right
       .app(PS.Data.Either.Module.Right
              .app(PS.Data.Either.Module.Right
                     .app(PS.Data.Either.Module.Right
                            .app(PS.Data.Either.Module.Right
                                   .app(PS.Data.Either.Module.Left.app(v))))))
  };
  @JvmField
  val in5 = { v : Any ->
     PS.Data.Either.Module.Right
       .app(PS.Data.Either.Module.Right
              .app(PS.Data.Either.Module.Right
                     .app(PS.Data.Either.Module.Right
                            .app(PS.Data.Either.Module.Left.app(v)))))
  };
  @JvmField
  val in4 = { v : Any ->
     PS.Data.Either.Module.Right
       .app(PS.Data.Either.Module.Right
              .app(PS.Data.Either.Module.Right
                     .app(PS.Data.Either.Module.Left.app(v))))
  };
  @JvmField
  val in3 = { v : Any ->
     PS.Data.Either.Module.Right
       .app(PS.Data.Either.Module.Right.app(PS.Data.Either.Module.Left.app(v)))
  };
  @JvmField
  val in2 = { v : Any ->
     PS.Data.Either.Module.Right.app(PS.Data.Either.Module.Left.app(v))
  };
  @JvmField
  val in10 = { v : Any ->
     PS.Data.Either.Module.Right
       .app(PS.Data.Either.Module.Right
              .app(PS.Data.Either.Module.Right
                     .app(PS.Data.Either.Module.Right
                            .app(PS.Data.Either.Module.Right
                                   .app(PS.Data.Either.Module.Right
                                          .app(PS.Data.Either.Module.Right
                                                 .app(
                  PS.Data.Either.Module.Right
                    .app(PS.Data.Either.Module.Right
                           .app(PS.Data.Either.Module.Left.app(v))))))))))
  };
  @JvmField val in1 = PS.Data.Either.Module.Left;
  @JvmField
  val either9 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             { f : Any ->
               { g : Any ->
                 { h : Any ->
                   { i : Any ->
                     { y : Any ->
                       when {
                        (y is PS.Data.Either.Module._Type_Either.Left) -> {
                          val r = y.value0;
                          a.app(r);
                        }
                        (y is PS.Data.Either.Module._Type_Either.Right) -> {
                          val __1 = y.value0;
                          when {
                            (__1 is PS.Data.Either.Module._Type_Either
                                      .Left) -> {
                              val r = __1.value0;
                              b.app(r);
                            }
                            (__1 is PS.Data.Either.Module._Type_Either
                                      .Right) -> {
                              val __2 = __1.value0;
                              when {
                                (__2 is PS.Data.Either.Module._Type_Either
                                          .Left) -> {
                                  val r = __2.value0;
                                  c.app(r);
                                }
                                (__2 is PS.Data.Either.Module._Type_Either
                                          .Right) -> {
                                  val __3 = __2.value0;
                                  when {
                                    (__3 is PS.Data.Either.Module._Type_Either
                                              .Left) -> {
                                      val r = __3.value0;
                                      d.app(r);
                                    }
                                    (__3 is PS.Data.Either.Module._Type_Either
                                              .Right) -> {
                                      val __4 = __3.value0;
                                      when {
                                        (__4 is PS.Data.Either.Module._Type_Either
                                                  .Left) -> {
                                          val r = __4.value0;
                                          e.app(r);
                                        }
                                        (__4 is PS.Data.Either.Module._Type_Either
                                                  .Right) -> {
                                          val __5 = __4.value0;
                                          when {
                                            (__5 is PS.Data.Either.Module._Type_Either
                                                      .Left) -> {
                                              val r = __5.value0;
                                              f.app(r);
                                            }
                                            (__5 is PS.Data.Either.Module._Type_Either
                                                      .Right) -> {
                                              val __6 = __5.value0;
                                              when {
                                                (__6 is PS.Data.Either.Module._Type_Either
                                                          .Left) -> {
                                                  val r = __6.value0;
                                                  g.app(r);
                                                }
                                                (__6 is PS.Data.Either.Module._Type_Either
                                                          .Right) -> {
                                                  val __7 = __6.value0;
                                                  when {
                                                    (__7 is PS.Data.Either.Module._Type_Either
                                                              .Left) -> {
                                                      val r = __7.value0;
                                                      h.app(r);
                                                    }
                                                    (__7 is PS.Data.Either.Module._Type_Either
                                                              .Right) -> {
                                                      val __8 = __7.value0;
                                                      when {
                                                        (__8 is PS.Data.Either.Module._Type_Either
                                                                  .Left) -> {
                                                          val r = __8.value0;
                                                          i.app(r);
                                                        }
                                                        (__8 is PS.Data.Either.Module._Type_Either
                                                                  .Right) -> {
                                                          val __9 = __8.value0;
                                                          PS.Data.Void.Module.absurd
                                                            .app(__9);
                                                        }
                                                        else -> (error(
                                                          "Error in Pattern Match"
                                                        ) as Any)
                                                      };
                                                    }
                                                    else -> (error(
                                                      "Error in Pattern Match"
                                                    ) as Any)
                                                  };
                                                }
                                                else -> (error(
                                                  "Error in Pattern Match"
                                                ) as Any)
                                              };
                                            }
                                            else -> (error(
                                              "Error in Pattern Match") as Any)
                                          };
                                        }
                                        else -> (error("Error in Pattern Match"
                                        ) as Any)
                                      };
                                    }
                                    else -> (error("Error in Pattern Match"
                                    ) as Any)
                                  };
                                }
                                else -> (error("Error in Pattern Match") as Any)
                              };
                            }
                            else -> (error("Error in Pattern Match") as Any)
                          };
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val either8 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             { f : Any ->
               { g : Any ->
                 { h : Any ->
                   { y : Any ->
                     when {
                      (y is PS.Data.Either.Module._Type_Either.Left) -> {
                        val r = y.value0;
                        a.app(r);
                      }
                      (y is PS.Data.Either.Module._Type_Either.Right) -> {
                        val __1 = y.value0;
                        when {
                          (__1 is PS.Data.Either.Module._Type_Either.Left) -> {
                            val r = __1.value0;
                            b.app(r);
                          }
                          (__1 is PS.Data.Either.Module._Type_Either.Right) -> {
                            val __2 = __1.value0;
                            when {
                              (__2 is PS.Data.Either.Module._Type_Either
                                        .Left) -> {
                                val r = __2.value0;
                                c.app(r);
                              }
                              (__2 is PS.Data.Either.Module._Type_Either
                                        .Right) -> {
                                val __3 = __2.value0;
                                when {
                                  (__3 is PS.Data.Either.Module._Type_Either
                                            .Left) -> {
                                    val r = __3.value0;
                                    d.app(r);
                                  }
                                  (__3 is PS.Data.Either.Module._Type_Either
                                            .Right) -> {
                                    val __4 = __3.value0;
                                    when {
                                      (__4 is PS.Data.Either.Module._Type_Either
                                                .Left) -> {
                                        val r = __4.value0;
                                        e.app(r);
                                      }
                                      (__4 is PS.Data.Either.Module._Type_Either
                                                .Right) -> {
                                        val __5 = __4.value0;
                                        when {
                                          (__5 is PS.Data.Either.Module._Type_Either
                                                    .Left) -> {
                                            val r = __5.value0;
                                            f.app(r);
                                          }
                                          (__5 is PS.Data.Either.Module._Type_Either
                                                    .Right) -> {
                                            val __6 = __5.value0;
                                            when {
                                              (__6 is PS.Data.Either.Module._Type_Either
                                                        .Left) -> {
                                                val r = __6.value0;
                                                g.app(r);
                                              }
                                              (__6 is PS.Data.Either.Module._Type_Either
                                                        .Right) -> {
                                                val __7 = __6.value0;
                                                when {
                                                  (__7 is PS.Data.Either.Module._Type_Either
                                                            .Left) -> {
                                                    val r = __7.value0;
                                                    h.app(r);
                                                  }
                                                  (__7 is PS.Data.Either.Module._Type_Either
                                                            .Right) -> {
                                                    val __8 = __7.value0;
                                                    PS.Data.Void.Module.absurd
                                                      .app(__8);
                                                  }
                                                  else -> (error(
                                                    "Error in Pattern Match"
                                                  ) as Any)
                                                };
                                              }
                                              else -> (error(
                                                "Error in Pattern Match"
                                              ) as Any)
                                            };
                                          }
                                          else -> (error(
                                            "Error in Pattern Match") as Any)
                                        };
                                      }
                                      else -> (error("Error in Pattern Match"
                                      ) as Any)
                                    };
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                };
                              }
                              else -> (error("Error in Pattern Match") as Any)
                            };
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val either7 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             { f : Any ->
               { g : Any ->
                 { y : Any ->
                   when {
                    (y is PS.Data.Either.Module._Type_Either.Left) -> {
                      val r = y.value0;
                      a.app(r);
                    }
                    (y is PS.Data.Either.Module._Type_Either.Right) -> {
                      val __1 = y.value0;
                      when {
                        (__1 is PS.Data.Either.Module._Type_Either.Left) -> {
                          val r = __1.value0;
                          b.app(r);
                        }
                        (__1 is PS.Data.Either.Module._Type_Either.Right) -> {
                          val __2 = __1.value0;
                          when {
                            (__2 is PS.Data.Either.Module._Type_Either
                                      .Left) -> {
                              val r = __2.value0;
                              c.app(r);
                            }
                            (__2 is PS.Data.Either.Module._Type_Either
                                      .Right) -> {
                              val __3 = __2.value0;
                              when {
                                (__3 is PS.Data.Either.Module._Type_Either
                                          .Left) -> {
                                  val r = __3.value0;
                                  d.app(r);
                                }
                                (__3 is PS.Data.Either.Module._Type_Either
                                          .Right) -> {
                                  val __4 = __3.value0;
                                  when {
                                    (__4 is PS.Data.Either.Module._Type_Either
                                              .Left) -> {
                                      val r = __4.value0;
                                      e.app(r);
                                    }
                                    (__4 is PS.Data.Either.Module._Type_Either
                                              .Right) -> {
                                      val __5 = __4.value0;
                                      when {
                                        (__5 is PS.Data.Either.Module._Type_Either
                                                  .Left) -> {
                                          val r = __5.value0;
                                          f.app(r);
                                        }
                                        (__5 is PS.Data.Either.Module._Type_Either
                                                  .Right) -> {
                                          val __6 = __5.value0;
                                          when {
                                            (__6 is PS.Data.Either.Module._Type_Either
                                                      .Left) -> {
                                              val r = __6.value0;
                                              g.app(r);
                                            }
                                            (__6 is PS.Data.Either.Module._Type_Either
                                                      .Right) -> {
                                              val __7 = __6.value0;
                                              PS.Data.Void.Module.absurd
                                                .app(__7);
                                            }
                                            else -> (error(
                                              "Error in Pattern Match") as Any)
                                          };
                                        }
                                        else -> (error("Error in Pattern Match"
                                        ) as Any)
                                      };
                                    }
                                    else -> (error("Error in Pattern Match"
                                    ) as Any)
                                  };
                                }
                                else -> (error("Error in Pattern Match") as Any)
                              };
                            }
                            else -> (error("Error in Pattern Match") as Any)
                          };
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      };
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  }
                }
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val either6 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             { f : Any ->
               { y : Any ->
                 when {
                  (y is PS.Data.Either.Module._Type_Either.Left) -> {
                    val r = y.value0;
                    a.app(r);
                  }
                  (y is PS.Data.Either.Module._Type_Either.Right) -> {
                    val __1 = y.value0;
                    when {
                      (__1 is PS.Data.Either.Module._Type_Either.Left) -> {
                        val r = __1.value0;
                        b.app(r);
                      }
                      (__1 is PS.Data.Either.Module._Type_Either.Right) -> {
                        val __2 = __1.value0;
                        when {
                          (__2 is PS.Data.Either.Module._Type_Either.Left) -> {
                            val r = __2.value0;
                            c.app(r);
                          }
                          (__2 is PS.Data.Either.Module._Type_Either.Right) -> {
                            val __3 = __2.value0;
                            when {
                              (__3 is PS.Data.Either.Module._Type_Either
                                        .Left) -> {
                                val r = __3.value0;
                                d.app(r);
                              }
                              (__3 is PS.Data.Either.Module._Type_Either
                                        .Right) -> {
                                val __4 = __3.value0;
                                when {
                                  (__4 is PS.Data.Either.Module._Type_Either
                                            .Left) -> {
                                    val r = __4.value0;
                                    e.app(r);
                                  }
                                  (__4 is PS.Data.Either.Module._Type_Either
                                            .Right) -> {
                                    val __5 = __4.value0;
                                    when {
                                      (__5 is PS.Data.Either.Module._Type_Either
                                                .Left) -> {
                                        val r = __5.value0;
                                        f.app(r);
                                      }
                                      (__5 is PS.Data.Either.Module._Type_Either
                                                .Right) -> {
                                        val __6 = __5.value0;
                                        PS.Data.Void.Module.absurd.app(__6);
                                      }
                                      else -> (error("Error in Pattern Match"
                                      ) as Any)
                                    };
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                };
                              }
                              else -> (error("Error in Pattern Match") as Any)
                            };
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    };
                  }
                  else -> (error("Error in Pattern Match") as Any)
                }
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val either5 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             { y : Any ->
               when {
                (y is PS.Data.Either.Module._Type_Either.Left) -> {
                  val r = y.value0;
                  a.app(r);
                }
                (y is PS.Data.Either.Module._Type_Either.Right) -> {
                  val __1 = y.value0;
                  when {
                    (__1 is PS.Data.Either.Module._Type_Either.Left) -> {
                      val r = __1.value0;
                      b.app(r);
                    }
                    (__1 is PS.Data.Either.Module._Type_Either.Right) -> {
                      val __2 = __1.value0;
                      when {
                        (__2 is PS.Data.Either.Module._Type_Either.Left) -> {
                          val r = __2.value0;
                          c.app(r);
                        }
                        (__2 is PS.Data.Either.Module._Type_Either.Right) -> {
                          val __3 = __2.value0;
                          when {
                            (__3 is PS.Data.Either.Module._Type_Either
                                      .Left) -> {
                              val r = __3.value0;
                              d.app(r);
                            }
                            (__3 is PS.Data.Either.Module._Type_Either
                                      .Right) -> {
                              val __4 = __3.value0;
                              when {
                                (__4 is PS.Data.Either.Module._Type_Either
                                          .Left) -> {
                                  val r = __4.value0;
                                  e.app(r);
                                }
                                (__4 is PS.Data.Either.Module._Type_Either
                                          .Right) -> {
                                  val __5 = __4.value0;
                                  PS.Data.Void.Module.absurd.app(__5);
                                }
                                else -> (error("Error in Pattern Match") as Any)
                              };
                            }
                            else -> (error("Error in Pattern Match") as Any)
                          };
                        }
                        else -> (error("Error in Pattern Match") as Any)
                      };
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  };
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val either4 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { y : Any ->
             when {
              (y is PS.Data.Either.Module._Type_Either.Left) -> {
                val r = y.value0;
                a.app(r);
              }
              (y is PS.Data.Either.Module._Type_Either.Right) -> {
                val __1 = y.value0;
                when {
                  (__1 is PS.Data.Either.Module._Type_Either.Left) -> {
                    val r = __1.value0;
                    b.app(r);
                  }
                  (__1 is PS.Data.Either.Module._Type_Either.Right) -> {
                    val __2 = __1.value0;
                    when {
                      (__2 is PS.Data.Either.Module._Type_Either.Left) -> {
                        val r = __2.value0;
                        c.app(r);
                      }
                      (__2 is PS.Data.Either.Module._Type_Either.Right) -> {
                        val __3 = __2.value0;
                        when {
                          (__3 is PS.Data.Either.Module._Type_Either.Left) -> {
                            val r = __3.value0;
                            d.app(r);
                          }
                          (__3 is PS.Data.Either.Module._Type_Either.Right) -> {
                            val __4 = __3.value0;
                            PS.Data.Void.Module.absurd.app(__4);
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        };
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    };
                  }
                  else -> (error("Error in Pattern Match") as Any)
                };
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        }
      }
    }
  };
  @JvmField
  val either3 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { y : Any ->
           when {
            (y is PS.Data.Either.Module._Type_Either.Left) -> {
              val r = y.value0;
              a.app(r);
            }
            (y is PS.Data.Either.Module._Type_Either.Right) -> {
              val __1 = y.value0;
              when {
                (__1 is PS.Data.Either.Module._Type_Either.Left) -> {
                  val r = __1.value0;
                  b.app(r);
                }
                (__1 is PS.Data.Either.Module._Type_Either.Right) -> {
                  val __2 = __1.value0;
                  when {
                    (__2 is PS.Data.Either.Module._Type_Either.Left) -> {
                      val r = __2.value0;
                      c.app(r);
                    }
                    (__2 is PS.Data.Either.Module._Type_Either.Right) -> {
                      val __3 = __2.value0;
                      PS.Data.Void.Module.absurd.app(__3);
                    }
                    else -> (error("Error in Pattern Match") as Any)
                  };
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    }
  };
  @JvmField
  val either2 = { a : Any ->
     { b : Any ->
       { y : Any ->
         when {
          (y is PS.Data.Either.Module._Type_Either.Left) -> {
            val r = y.value0;
            a.app(r);
          }
          (y is PS.Data.Either.Module._Type_Either.Right) -> {
            val __1 = y.value0;
            when {
              (__1 is PS.Data.Either.Module._Type_Either.Left) -> {
                val r = __1.value0;
                b.app(r);
              }
              (__1 is PS.Data.Either.Module._Type_Either.Right) -> {
                val __2 = __1.value0;
                PS.Data.Void.Module.absurd.app(__2);
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val either10 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             { f : Any ->
               { g : Any ->
                 { h : Any ->
                   { i : Any ->
                     { j : Any ->
                       { y : Any ->
                         when {
                          (y is PS.Data.Either.Module._Type_Either.Left) -> {
                            val r = y.value0;
                            a.app(r);
                          }
                          (y is PS.Data.Either.Module._Type_Either.Right) -> {
                            val __1 = y.value0;
                            when {
                              (__1 is PS.Data.Either.Module._Type_Either
                                        .Left) -> {
                                val r = __1.value0;
                                b.app(r);
                              }
                              (__1 is PS.Data.Either.Module._Type_Either
                                        .Right) -> {
                                val __2 = __1.value0;
                                when {
                                  (__2 is PS.Data.Either.Module._Type_Either
                                            .Left) -> {
                                    val r = __2.value0;
                                    c.app(r);
                                  }
                                  (__2 is PS.Data.Either.Module._Type_Either
                                            .Right) -> {
                                    val __3 = __2.value0;
                                    when {
                                      (__3 is PS.Data.Either.Module._Type_Either
                                                .Left) -> {
                                        val r = __3.value0;
                                        d.app(r);
                                      }
                                      (__3 is PS.Data.Either.Module._Type_Either
                                                .Right) -> {
                                        val __4 = __3.value0;
                                        when {
                                          (__4 is PS.Data.Either.Module._Type_Either
                                                    .Left) -> {
                                            val r = __4.value0;
                                            e.app(r);
                                          }
                                          (__4 is PS.Data.Either.Module._Type_Either
                                                    .Right) -> {
                                            val __5 = __4.value0;
                                            when {
                                              (__5 is PS.Data.Either.Module._Type_Either
                                                        .Left) -> {
                                                val r = __5.value0;
                                                f.app(r);
                                              }
                                              (__5 is PS.Data.Either.Module._Type_Either
                                                        .Right) -> {
                                                val __6 = __5.value0;
                                                when {
                                                  (__6 is PS.Data.Either.Module._Type_Either
                                                            .Left) -> {
                                                    val r = __6.value0;
                                                    g.app(r);
                                                  }
                                                  (__6 is PS.Data.Either.Module._Type_Either
                                                            .Right) -> {
                                                    val __7 = __6.value0;
                                                    when {
                                                      (__7 is PS.Data.Either.Module._Type_Either
                                                                .Left) -> {
                                                        val r = __7.value0;
                                                        h.app(r);
                                                      }
                                                      (__7 is PS.Data.Either.Module._Type_Either
                                                                .Right) -> {
                                                        val __8 = __7.value0;
                                                        when {
                                                          (__8 is PS.Data.Either.Module._Type_Either
                                                                    .Left) -> {
                                                            val r = __8.value0;
                                                            i.app(r);
                                                          }
                                                          (__8 is PS.Data.Either.Module._Type_Either
                                                                    .Right) -> {
                                                            val __9 = __8
                                                                        .value0;
                                                            when {
                                                              (__9 is PS.Data.Either.Module._Type_Either
                                                                        .Left) -> {
                                                                val r = __9
                                                                          .value0;
                                                                j.app(r);
                                                              }
                                                              (__9 is PS.Data.Either.Module._Type_Either
                                                                        .Right) -> {
                                                                val __10 = __9
                                                                             .value0;
                                                                PS.Data.Void.Module.absurd
                                                                  .app(__10);
                                                              }
                                                              else -> (error(
                                                                "Error in Pattern Match"
                                                              ) as Any)
                                                            };
                                                          }
                                                          else -> (error(
                                                            "Error in Pattern Match"
                                                          ) as Any)
                                                        };
                                                      }
                                                      else -> (error(
                                                        "Error in Pattern Match"
                                                      ) as Any)
                                                    };
                                                  }
                                                  else -> (error(
                                                    "Error in Pattern Match"
                                                  ) as Any)
                                                };
                                              }
                                              else -> (error(
                                                "Error in Pattern Match"
                                              ) as Any)
                                            };
                                          }
                                          else -> (error(
                                            "Error in Pattern Match") as Any)
                                        };
                                      }
                                      else -> (error("Error in Pattern Match"
                                      ) as Any)
                                    };
                                  }
                                  else -> (error("Error in Pattern Match"
                                  ) as Any)
                                };
                              }
                              else -> (error("Error in Pattern Match") as Any)
                            };
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val either1 = { y : Any ->
     when {
      (y is PS.Data.Either.Module._Type_Either.Left) -> {
        val r = y.value0;
        r;
      }
      (y is PS.Data.Either.Module._Type_Either.Right) -> {
        val __1 = y.value0;
        PS.Data.Void.Module.absurd.app(__1);
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val at9 = { b : Any ->
     { f : Any ->
       { y : Any ->
         when {
          (y is PS.Data.Either.Module._Type_Either
                  .Right)&& (y
                               .value0 is PS.Data.Either.Module._Type_Either
                                            .Right)&& (y
                                                         .value0
                                                         .value0 is PS.Data.Either.Module._Type_Either
                                                                      .Right)&&
          (y
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Right)&& (y
                                       .value0
                                       .value0
                                       .value0
                                       .value0 is PS.Data.Either.Module._Type_Either
                                                    .Right)&& (y
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0 is PS.Data.Either.Module._Type_Either
                                                                              .Right)&&
          (y
             .value0
             .value0
             .value0
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Right)&& (y
                                       .value0
                                       .value0
                                       .value0
                                       .value0
                                       .value0
                                       .value0
                                       .value0 is PS.Data.Either.Module._Type_Either
                                                    .Right)&& (y
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0 is PS.Data.Either.Module._Type_Either
                                                                              .Left) -> {
            val r = y
                      .value0
                      .value0
                      .value0
                      .value0
                      .value0
                      .value0
                      .value0
                      .value0
                      .value0;
            f.app(r);
          }
          else -> {
            b;
          }
        }
      }
    }
  };
  @JvmField
  val at8 = { b : Any ->
     { f : Any ->
       { y : Any ->
         when {
          (y is PS.Data.Either.Module._Type_Either
                  .Right)&& (y
                               .value0 is PS.Data.Either.Module._Type_Either
                                            .Right)&& (y
                                                         .value0
                                                         .value0 is PS.Data.Either.Module._Type_Either
                                                                      .Right)&&
          (y
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Right)&& (y
                                       .value0
                                       .value0
                                       .value0
                                       .value0 is PS.Data.Either.Module._Type_Either
                                                    .Right)&& (y
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0 is PS.Data.Either.Module._Type_Either
                                                                              .Right)&&
          (y
             .value0
             .value0
             .value0
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Right)&& (y
                                       .value0
                                       .value0
                                       .value0
                                       .value0
                                       .value0
                                       .value0
                                       .value0 is PS.Data.Either.Module._Type_Either
                                                    .Left) -> {
            val r = y.value0.value0.value0.value0.value0.value0.value0.value0;
            f.app(r);
          }
          else -> {
            b;
          }
        }
      }
    }
  };
  @JvmField
  val at7 = { b : Any ->
     { f : Any ->
       { y : Any ->
         when {
          (y is PS.Data.Either.Module._Type_Either
                  .Right)&& (y
                               .value0 is PS.Data.Either.Module._Type_Either
                                            .Right)&& (y
                                                         .value0
                                                         .value0 is PS.Data.Either.Module._Type_Either
                                                                      .Right)&&
          (y
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Right)&& (y
                                       .value0
                                       .value0
                                       .value0
                                       .value0 is PS.Data.Either.Module._Type_Either
                                                    .Right)&& (y
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0 is PS.Data.Either.Module._Type_Either
                                                                              .Right)&&
          (y
             .value0
             .value0
             .value0
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Left) -> {
            val r = y.value0.value0.value0.value0.value0.value0.value0;
            f.app(r);
          }
          else -> {
            b;
          }
        }
      }
    }
  };
  @JvmField
  val at6 = { b : Any ->
     { f : Any ->
       { y : Any ->
         when {
          (y is PS.Data.Either.Module._Type_Either
                  .Right)&& (y
                               .value0 is PS.Data.Either.Module._Type_Either
                                            .Right)&& (y
                                                         .value0
                                                         .value0 is PS.Data.Either.Module._Type_Either
                                                                      .Right)&&
          (y
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Right)&& (y
                                       .value0
                                       .value0
                                       .value0
                                       .value0 is PS.Data.Either.Module._Type_Either
                                                    .Right)&& (y
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0 is PS.Data.Either.Module._Type_Either
                                                                              .Left) -> {
            val r = y.value0.value0.value0.value0.value0.value0;
            f.app(r);
          }
          else -> {
            b;
          }
        }
      }
    }
  };
  @JvmField
  val at5 = { b : Any ->
     { f : Any ->
       { y : Any ->
         when {
          (y is PS.Data.Either.Module._Type_Either
                  .Right)&& (y
                               .value0 is PS.Data.Either.Module._Type_Either
                                            .Right)&& (y
                                                         .value0
                                                         .value0 is PS.Data.Either.Module._Type_Either
                                                                      .Right)&&
          (y
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Right)&& (y
                                       .value0
                                       .value0
                                       .value0
                                       .value0 is PS.Data.Either.Module._Type_Either
                                                    .Left) -> {
            val r = y.value0.value0.value0.value0.value0;
            f.app(r);
          }
          else -> {
            b;
          }
        }
      }
    }
  };
  @JvmField
  val at4 = { b : Any ->
     { f : Any ->
       { y : Any ->
         when {
          (y is PS.Data.Either.Module._Type_Either
                  .Right)&& (y
                               .value0 is PS.Data.Either.Module._Type_Either
                                            .Right)&& (y
                                                         .value0
                                                         .value0 is PS.Data.Either.Module._Type_Either
                                                                      .Right)&&
          (y
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Left) -> {
            val r = y.value0.value0.value0.value0;
            f.app(r);
          }
          else -> {
            b;
          }
        }
      }
    }
  };
  @JvmField
  val at3 = { b : Any ->
     { f : Any ->
       { y : Any ->
         when {
          (y is PS.Data.Either.Module._Type_Either
                  .Right)&& (y
                               .value0 is PS.Data.Either.Module._Type_Either
                                            .Right)&& (y
                                                         .value0
                                                         .value0 is PS.Data.Either.Module._Type_Either
                                                                      .Left) -> {
            val r = y.value0.value0.value0;
            f.app(r);
          }
          else -> {
            b;
          }
        }
      }
    }
  };
  @JvmField
  val at2 = { b : Any ->
     { f : Any ->
       { y : Any ->
         when {
          (y is PS.Data.Either.Module._Type_Either
                  .Right)&& (y
                               .value0 is PS.Data.Either.Module._Type_Either
                                            .Left) -> {
            val r = y.value0.value0;
            f.app(r);
          }
          else -> {
            b;
          }
        }
      }
    }
  };
  @JvmField
  val at10 = { b : Any ->
     { f : Any ->
       { y : Any ->
         when {
          (y is PS.Data.Either.Module._Type_Either
                  .Right)&& (y
                               .value0 is PS.Data.Either.Module._Type_Either
                                            .Right)&& (y
                                                         .value0
                                                         .value0 is PS.Data.Either.Module._Type_Either
                                                                      .Right)&&
          (y
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Right)&& (y
                                       .value0
                                       .value0
                                       .value0
                                       .value0 is PS.Data.Either.Module._Type_Either
                                                    .Right)&& (y
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0 is PS.Data.Either.Module._Type_Either
                                                                              .Right)&&
          (y
             .value0
             .value0
             .value0
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Right)&& (y
                                       .value0
                                       .value0
                                       .value0
                                       .value0
                                       .value0
                                       .value0
                                       .value0 is PS.Data.Either.Module._Type_Either
                                                    .Right)&& (y
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0
                                                                 .value0 is PS.Data.Either.Module._Type_Either
                                                                              .Right)&&
          (y
             .value0
             .value0
             .value0
             .value0
             .value0
             .value0
             .value0
             .value0
             .value0 is PS.Data.Either.Module._Type_Either
                          .Left) -> {
            val r = y
                      .value0
                      .value0
                      .value0
                      .value0
                      .value0
                      .value0
                      .value0
                      .value0
                      .value0
                      .value0;
            f.app(r);
          }
          else -> {
            b;
          }
        }
      }
    }
  };
  @JvmField
  val at1 = { b : Any ->
     { f : Any ->
       { y : Any ->
         when {
          (y is PS.Data.Either.Module._Type_Either.Left) -> {
            val r = y.value0;
            f.app(r);
          }
          else -> {
            b;
          }
        }
      }
    }
  };
}